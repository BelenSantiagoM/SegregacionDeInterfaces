package com.example.principiosi_reservacionhabitaciones

class RoomService: ICRUDRoom<Room> {
    private var roomList:MutableList <Room> = mutableListOf()
    override fun add(entity: Room) {
        this.roomList.add(entity)
    }

    override fun get(id: Int): Room? {
        for (elemento in roomList)
            if(id==elemento.roomNumber)
                return elemento
        return null
    }

    /*override fun delete(id: Int): Boolean {
        val roomSearch : Room?= get(id)
        if(roomSearch!=null) {
            roomList.remove(roomSearch)
            return true
        }
        return false
    }*/

    override fun getList(): MutableList<Room> {
        return roomList
    }

    /*override fun update(entity: Room) {
        val pos: Int = getPos(entity.roomNumber)
        roomList[pos] = entity
    }*/

    fun getPos(id:Int) : Int{
        for (elemento in roomList)
            if(id==elemento.roomNumber)
                return roomList.indexOf(elemento)
        return -1
    }
}