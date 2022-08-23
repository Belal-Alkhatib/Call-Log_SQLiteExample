package com.example.aluc_sqlite.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aluc_sqlite.model.Call

class mySqLiteDB(val context:Context):SQLiteOpenHelper(context , NAME ,null , VERSION) {
    private lateinit var db:SQLiteDatabase
    init {
        db = this.writableDatabase
    }
    companion object{
        var NAME = "database"
        var VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE calls (id INTEGER PRIMARY KEY AUTOINCREMENT , name VARCHAR(50) NOT NULL , number VARCHAR(50) , type VARCHAR(50) )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS calls")
        onCreate(db)
    }

    fun addCall(call:Call):Boolean{
        val cv = ContentValues()
        cv.apply {
            put("type" , call.type.toInt())
            put("name", call.name)
            put("number", call.number)
        }
        return writableDatabase.insert("calls",null,cv)>0
    }

    fun getAllCalls():ArrayList<Call>{
        var arr = ArrayList<Call>()
        val c = readableDatabase.rawQuery("select * from calls" , null )
        if(c.count >0 ){
            c.moveToFirst()
            while (!c.isAfterLast){
                val type = c.getString(0)
                val name = c.getString(1)
                val number = c.getString(2)
                val id = c.getInt(3)
                arr.add(Call(name, number, type))
                c.moveToNext()
                c.close()
            }
        }
        return arr
    }

    fun delet(id:Int):Boolean{
        return db.delete("calls","id = $id",null)>0
    }
}