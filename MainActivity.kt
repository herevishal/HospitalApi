package com.example.recyapp
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.hospitalClickListener {
    var hospitalsData: ArrayList<Hospitals> = ArrayList()
    override fun getItem(position: Int) {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(hospitalsData.get(position).hospitalName)
        alertDialog.setMessage(hospitalsData.get(position).address)
        alertDialog.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.recyclerview_demo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getHospitalsList().enqueue(object : Callback<ArrayList<Hospitals>> {
            override fun onResponse(call: Call<ArrayList<Hospitals>>?, response: Response<ArrayList<Hospitals>>?) {
                hospitalsData = response?.body()!!
                recyclerView.adapter = RecyclerViewAdapter(response?.body()!!, this@MainActivity)
            }

            override fun onFailure(call: Call<ArrayList<Hospitals>>?, t: Throwable?) {
            }
        })


    }
}
