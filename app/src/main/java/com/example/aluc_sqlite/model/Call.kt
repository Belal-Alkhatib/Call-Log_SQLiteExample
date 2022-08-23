package com.example.aluc_sqlite.model

import java.io.Serializable

//Call(var id:Int , var name:String , var number:String , var img:Int)\
//var name:String , var number:String , var type:String
data class Call(var name:String , var number:String , var type:String):Serializable
