package pizzarestaurant.model


import pizzarestaurant.management.PizzaMaker


class Table(private val id: Int) {
    private var customers = 0


    fun seatCustomers(count: Int) {
        customers = count
        println("[MESA $id] $customers clientes sentados.")
    }


    fun takeOrder(pizzaMaker: PizzaMaker) {
        val pizzasOrdered = (1..customers).random()
        println("[MESA $id] Pide $pizzasOrdered pizzas.")
        repeat(pizzasOrdered) {
            if (!pizzaMaker.makePizza()) return
        }
    }


    fun clearTable() {
        println("[MESA $id] Clientes se retiran.")
        customers = 0
    }
}
