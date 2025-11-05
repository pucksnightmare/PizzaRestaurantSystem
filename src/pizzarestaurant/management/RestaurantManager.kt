package pizzarestaurant.management

import pizzarestaurant.model.Delivery
import pizzarestaurant.model.Table
import pizzarestaurant.utils.TimeUtils

class RestaurantManager {
    private val inventory = Inventory()
    private val pizzaMaker = PizzaMaker(inventory)
    private val delivery = Delivery(pizzaMaker)
    private val tables = List(6) { Table(it + 1) }


    fun simulateDay(dayName: String) {
        println("\n==============================")
        println("Día: $dayName")
        println("==============================")


        pizzaMaker.resetPizzasMade()


        // Rellenar inventario (9am–2pm)
        println("\n9am–2pm: Reabasteciendo inventario...")
        inventory.restock()
        inventory.showInventory()
        TimeUtils.sleepSimulated(0.2)


        // Simular el horario de servicio: 2pm a 12am (10 horas)
        println("2pm–12am: Restaurante abierto\n")


        var currentHour = 14
        val closingHour = 24

    }
}