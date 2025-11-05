package pizzarestaurant.model


import pizzarestaurant.management.PIzzaMaker


class Delivery(private val pizzaMaker: PIzzaMaker) {
    fun processOrder() {
        val pizzasOrdered = (1..3).random()
        println("[DOMICILIO] Pedido recibido de $pizzasOrdered pizzas.")
        repeat(pizzasOrdered) {
            if (!pizzaMaker.makePizza()) return
        }
        println("[DOMICILIO] Pedido entregado.")
    }
}
