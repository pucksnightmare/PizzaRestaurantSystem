package pizzarestaurant.model


import pizzarestaurant.management.PizzaMaker


class Delivery(private val pizzaMaker: PizzaMaker) {
    fun processOrder() {
        val pizzasOrdered = (1..3).random()
        println("[DOMICILIO] Pedido recibido de $pizzasOrdered pizzas.")
        repeat(pizzasOrdered) {
            if (!pizzaMaker.makePizza()) return
        }
        println("[DOMICILIO] Pedido entregado.")
    }
}
