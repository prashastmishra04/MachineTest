package com.example.grid

import ListData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var userList: List<ListData> = emptyList<ListData>()
    lateinit var gridView: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.grid_view);
        val listAdapter = Adpater(userList)
        ApiClient().getApiClient()?.create(ApiInterface::class.java).also { it ->
            if (it != null) {
                it.getUser().enqueue(object : retrofit2.Callback<ListData> {
                    override fun onResponse(
                            call: Call<ListData>,
                            response: Response<ListData>
                    ) {
                        if (response.isSuccessful) {
                            Log.i("success", "success")
                            response?.body()?.let {
                                response?.body()?.let {
                                    listAdapter.users
                                }
                            }

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