package com.example.grid

import ListData
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var userList: List<ListData> = emptyList<ListData>()
    lateinit var gridView: GridView
    lateinit var nestedSV: NestedScrollView
    var listAdapter = Adpater(userList)
    override fun onCreate(savedInstanceState: Bundle?) {
        var userList: List<ListData> = emptyList<ListData>()

        gridView.adapter = (gridView).adapter
        // lateinit var recyclerView: GridView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gridView = findViewById(R.id.grid_view)
        nestedSV = findViewById(R.id.idNestedSV);
        var page = 0
        val limit = 2
//        recyclerView.G = LinearLayoutManager(this)
        nestedSV.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                page++
                getData()
            }
        })
    }

    fun getData() {
        ApiClient().getApiClient()?.create(ApiInterface::class.java).also {
            if (it != null) {
                it.getUser().enqueue(object : retrofit2.Callback<ListData> {
                    override fun onResponse(call: Call<ListData>, response: Response<ListData>) {
                        if (response.isSuccessful) {
                            Log.i("success", "success")
                            listAdapter.updateList(userList)

                        } else {
                            Log.i("unsuccess", "unsuccess")
                        }
                    }

                    override fun onFailure(call: Call<ListData>, t: Throwable) {
                        Log.i("try agai", "try again")
                    }

                })
            }
        }

    }
}