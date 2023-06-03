package com.example.principiosi_reservacionhabitaciones

interface ICRUDRoom <T> {
    fun add( entity: T)
    fun get(id:Int): T?
    fun getList():MutableList<T>
}