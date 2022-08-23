package com.example.aluc_sqlite.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import com.example.aluc_sqlite.R
import com.example.aluc_sqlite.databinding.CallItemBinding
import com.example.aluc_sqlite.model.Call

class CallAdapter( var data:ArrayList<Call>):BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {

    return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val binding = CallItemBinding.inflate(LayoutInflater.from(parent!!.context),parent , false)
        val call = data[position]
        //val call = getItem(position)as Call
        binding.tvName.text = call.name
        binding.tvNum.text = call.number
        when(call.type){
            "لم يتم الرد عليها" -> {binding.imgCall.setImageResource(R.drawable.ic_baseline_call_missed_24)}
            "صادرة" -> {binding.imgCall.setImageResource(R.drawable.ic_baseline_call_made_24)}
            "واردة" -> {binding.imgCall.setImageResource(R.drawable.ic_baseline_call_received_24)}
        }

        return binding.root
    }


}