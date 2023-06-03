package com.example.principiosi_reservacionhabitaciones


fun main(){

    println("Principio de Segregación de Interfaces")

    //--------- USANDO EL CRUD PARA HUESPEDES -----------------//

    //instanciando el objeto guestService
    val guestService: GuestService = GuestService()

    //Agregar huespedes
    //1
    val guest1: Guest = Guest(
        12345,
        "Belén",
        "Santiago Martínez",
        "Oaxaca",
    )
    guestService.add(guest1)
    //2
    val guest2 = Guest(
        12346,
        "Jorge Benito",
        "Alavez Alavez",
        "Oaxaca",
    )
    guestService.add(guest2)
    //3
    val guest3 = Guest(
        12347,
        "Clemente Eduardo",
        "Vasquez Reyes",
        "Oaxaca",
    )
    guestService.add(guest3)
    //4
    val guest4 = Guest(
        12348,
        "Ruby",
        "García Vargas",
        "Huatulco",
    )
    guestService.add(guest4)

    //Búsqueda de un elemento
    println("Mostrando solo un huesped en específico")
    val guestSearch1 : Guest?= guestService.get(12346)
    if (guestSearch1!=null)
        println(" ${guestSearch1.IdNumber}, ${guestSearch1.name}," +
                " ${guestSearch1.lastNames},${guestSearch1.origin}")
    else
        println("No existe el huésped")

    //Consulta de todos los huespedes
    println("Listar todos los huespedes")
    var guestList : MutableList<Guest> = guestService.getList()
    for (elemento in guestList){
        println(" ${elemento.IdNumber}, ${elemento.name}," +
                " ${elemento.lastNames},${elemento.origin}")

    }

    //Eliminando un huesped
    println("Eliminando un huésped")
    if(guestService.delete(12346))
        println("Huésped Eliminado")
    else
        println("El huésped No existe")

    //Consulta de todos los huespedes
    println("Listar todos los huespedes")
    guestList = guestService.getList()
    for (elemento in guestList){
        println(" ${elemento.IdNumber}, ${elemento.name}," +
                " ${elemento.lastNames},${elemento.origin}")

    }

    //Editar y/o actualizar un huésped
    println("Actualizar los datos de un huésped")

    //Primero buscamos el huésped
    val guestSearch2 : Guest?= guestService.get(12347)
    if (guestSearch2!=null) {
        println(
            " ${guestSearch2.IdNumber}, ${guestSearch2.name}," +
                    " ${guestSearch2.lastNames},${guestSearch2.origin}"
        )
        guestSearch2.IdNumber = 11223
        guestSearch2.name="Daniel"
        guestSearch2.lastNames="Sanchez Porras"
        guestSearch2.origin="México"
        //Pasamos el objeto ya actualizado
        guestService.update(guestSearch2)
    }
    else
        println("No existe el huésped")

    //Consulta de todos los huespedes
    println("Listar todos los huespedes")
    guestList = guestService.getList()
    for (elemento in guestList){
        println(" ${elemento.IdNumber}, ${elemento.name}," +
                " ${elemento.lastNames},${elemento.origin}")

    }

    //--------- USANDO EL CRUD PARA HABITACIONES -----------------//

    //creando el objeto de tipo RoomService
    val roomService: RoomService = RoomService()

    //Agregando habitaciones y sus datos a traves de un ciclo for
    for (i in 1 .. 10)
        if(i<6) roomService.add(Room(i,500.0f,1))
        else roomService.add(Room(i,1000.0f,1))

    //Consulta de todas las habitaciones
    println("Listar todas las habitaciones")
    var roomList : MutableList<Room> = roomService.getList()
    roomList = roomService.getList()
    for (elemento in roomList) {
        println(
            " ${elemento.roomNumber}, ${elemento.price}," +
                    " ${elemento.status}"
        )
    }
}