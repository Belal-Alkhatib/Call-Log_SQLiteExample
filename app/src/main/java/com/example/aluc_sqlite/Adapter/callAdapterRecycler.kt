package com.example.aass4_listview.Adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aluc_sqlite.Activitys.CallsAct
import com.example.aluc_sqlite.databinding.CallItem2Binding
import com.example.aluc_sqlite.model.Call

class callAdapterRecycler(var activity: CallsAct, var data: ArrayList<Call>):RecyclerView.Adapter<callAdapterRecycler.MyViewHolder>(){
    class MyViewHolder(var itemrBinding: CallItem2Binding) : RecyclerView.ViewHolder(itemrBinding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CallItem2Binding.inflate(activity.layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//تستخدم لتعبئة البيانات
        holder.itemrBinding.tvName.text = data[position].name.toString()
        holder.itemrBinding.tvNum.text = data[position].number.toString()
        holder.itemrBinding.imgCall.setImageResource(data[position].type.toInt())
    }

    override fun getItemCount(): Int {
        return data.size
    }
}