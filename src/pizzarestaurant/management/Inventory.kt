package pizzarestaurant.management

class Inventory {
    private val maxStock = mapOf(
        "Masa" to 50,
        "Salsa de Tomate" to 60,
        "Queso" to 70,
        "Pepperoni" to 55
    )

    private val currentStock = mutableMapOf<String, Int>()

    init {
        for (item in maxStock.keys) {
            currentStock[item] = 0
        }
    }

    fun restock() {
        println("[INVENTARIO] Rellenando ingredientes hasta su capacidad máxima...")
        for ((ingredient, maxAmount) in maxStock) {
            val current = currentStock[ingredient] ?: 0
            val added = maxAmount - current
            currentStock[ingredient] = maxAmount
            println("   - $ingredient rellenado con $added unidades (Total: $maxAmount)")
        }
    }

    fun showInventory() {
        println("\n=== Inventario Actual ===")
        for ((ingredient, amount) in currentStock) {
            val max = maxStock[ingredient]
            println("$ingredient: $amount/$max")
        }
        println("=========================\n")
    }



}