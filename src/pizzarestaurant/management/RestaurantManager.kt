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

        while (currentHour < closingHour && pizzaMaker.pizzasMade < 30 && inventory.hasIngredients()) {
            println("\nHora actual: ${formatHour(currentHour)}")


            val events = (1..3).random() // número de eventos por hora


            repeat(events) {
                val action = (1..2).random()
                if (action == 1) {
                    val table = tables.random()
                    table.seatCustomers((1..4).random())
                    table.takeOrder(pizzaMaker)
                    table.clearTable()
                } else {
                    delivery.processOrder()
                }


                if (!inventory.hasIngredients() || pizzaMaker.pizzasMade >= 30) {
                    println("\nEl restaurante debe cerrar antes de tiempo.")
                    break
                }
            }


            inventory.showInventory()
            TimeUtils.sleepSimulated(0.1)
            currentHour++
        }


        println("\nCierre del restaurante.")
        println("Hora de cierre: ${formatHour(currentHour)}")
        println("Total de pizzas vendidas: ${pizzaMaker.pizzasMade}")
    }


    private fun formatHour(hour: Int): String {
        return when {
            hour < 12 -> "${hour}am"
            hour == 12 -> "12pm"
            hour < 24 -> "${hour - 12}pm"
            else -> "12am"
        }
    }

}


