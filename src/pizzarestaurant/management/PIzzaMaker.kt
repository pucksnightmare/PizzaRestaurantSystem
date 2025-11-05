package pizzarestaurant.management

import pizzarestaurant.utils.TimeUtils

class PIzzaMaker (private val inventory: Inventory){
    var pizzasMade = 0
        private set


    fun makePizza(): Boolean {
        if (!inventory.useIngredients()) {
            return false
        }


        TimeUtils.sleepSimulated(0.05)
        pizzasMade++
        println("[COCINA] Pizza #$pizzasMade preparada.")
        return true
    }


    fun resetPizzasMade() {
        pizzasMade = 0
    }
}