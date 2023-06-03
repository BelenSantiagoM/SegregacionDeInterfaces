package com.example.principiosi_reservacionhabitaciones

class GuestService:ICRUDGuest<Guest>, ICRUDRoom<Guest> {
    private var guestList:MutableList <Guest> = mutableListOf()
    override fun add(entity: Guest) {
        this.guestList.add(entity)
    }

    override fun get(id: Int): Guest? {
        //Búsqueda en específico de un objeto
        for (elemento in guestList)
            if(id==elemento.IdNumber)
                return elemento
        return null
    }

    override fun getList(): MutableList<Guest> {
        return guestList
    }

    override fun delete(id: Int) : Boolean{
        val guestSearch : Guest?= get(id)
        if(guestSearch!=null) {
            guestList.remove(guestSearch)
            return true
        }
        return false
    }

    override fun update(entity: Guest) {
        val pos: Int = getPos(entity.IdNumber)
        guestList[pos] = entity
    }

    fun getPos(id:Int) : Int{
        for (elemento in guestList)
            if(id==elemento.IdNumber)
                return guestList.indexOf(elemento)
        return -1
    }
}