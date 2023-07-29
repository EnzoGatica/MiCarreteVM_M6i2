package com.example.micarretevm_m6i2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_item")
data class Item(val nombre:String, val precio: Int, val cantidad: Int){
    @PrimaryKey (autoGenerate = true) var id : Long = 0
}