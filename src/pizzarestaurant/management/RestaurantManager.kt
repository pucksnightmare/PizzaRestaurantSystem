package pizzarestaurant.management

import pizzarestaurant.model.Delivery
import pizzarestaurant.model.Table
import pizzarestaurant.utils.TimeUtils

class RestaurantManager {
    private val inventory = Inventory()
    private val pizzaMaker = PizzaMaker(inventory)
    private val delivery = Delivery(pizzaMaker)
    private val tables = List(6) { Table(it + 1) }
}