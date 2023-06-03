package com.example.principiosi_reservacionhabitaciones

interface ICRUDGuest <T> {
    fun delete(id: Int):Boolean
    fun update(entity: T)
}