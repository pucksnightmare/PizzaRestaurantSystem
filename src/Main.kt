import pizzarestaurant.management.RestaurantManager

fun main() {
    val manager = RestaurantManager()
    val days = listOf("Jueves", "Viernes", "Sábado", "Domingo")
    for (day in days) {
        manager.simulateDay(day)
    }
    println("\nSimulación completada.")
}