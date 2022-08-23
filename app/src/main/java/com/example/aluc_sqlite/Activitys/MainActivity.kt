package com.example.aluc_sqlite.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aluc_sqlite.DB.mySqLiteDB
import com.example.aluc_sqlite.databinding.ActivityMainBinding
import com.example.aluc_sqlite.model.Call

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = ArrayList<Call>()

        binding.btnAdd.setOnClickListener {
            val name = binding.txtName.text.toString()
            val number = binding.txtNum.text.toString()
            val type = binding.spCalls.selectedItem.toString()

            val c = Call(name, number, type)

        val db = mySqLiteDB(this)
           if( db.addCall(c))
            Toast.makeText(this , "تمت الإضافة بنجاح" , Toast.LENGTH_SHORT).show()

            //CallsAct.calls.add(c)
         //toast
        }

        binding.btnRecord.setOnClickListener {
            val i = Intent(this , CallsAct::class.java)
            startActivity(i)
        }














      /*  val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var data = ArrayList<Call>()

        binding.btnAdd.setOnClickListener {
            val name = binding.txtName.text.toString()
            val number = binding.txtNum.text.toString()
            val type = binding.spCalls.selectedItem.toString()

            val c = Call(name, number, type)


            CallsAct.calls.add(c)

            Toast.makeText(this , "تمت الإضافة بنجاح" , Toast.LENGTH_SHORT).show()
            //toast
        }

        binding.btnRecord.setOnClickListener {
            val i = Intent(this , CallsAct::class.java)
            startActivity(i)
        }


*/
    }
}