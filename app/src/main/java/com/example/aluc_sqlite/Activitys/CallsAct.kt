package com.example.aluc_sqlite.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aass4_listview.Adapters.callAdapterRecycler
import com.example.aluc_sqlite.databinding.ActivityCallsBinding
import com.example.aluc_sqlite.model.Call


class CallsAct : AppCompatActivity() {

    private lateinit var binding : ActivityCallsBinding
    companion object{
        val calls = arrayListOf<Call>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lvCalls.layoutManager = LinearLayoutManager(this)
        val callAdapterRecycler = callAdapterRecycler(this, calls)
        binding.lvCalls.adapter=callAdapterRecycler


    }



   /* lateinit var binding : ActivityCallsBinding
    companion object{
        val calls = arrayListOf<Call>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallsBinding.inflate(layoutInflater)
       setContentView(binding.root)
        binding.lvCalls.adapter = CallAdapter(calls)


    }
    */

}