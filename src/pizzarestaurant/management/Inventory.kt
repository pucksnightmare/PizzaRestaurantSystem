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

    fun useIngredients(): Boolean {
        // Ingredientes necesarios por pizza (aleatorio, pero dentro de rangos razonables)
        val required = mapOf(
            "Masa" to 1,
            "Salsa de Tomate" to (1..2).random(),
            "Queso" to (1..3).random(),
            "Pepperoni" to (0..2).random()
        )


        // Verificar disponibilidad
        for ((ingredient, needed) in required) {
            val available = currentStock[ingredient] ?: 0
            if (available < needed) {
                println("[INVENTARIO] No hay suficiente $ingredient. Restaurante debe cerrar.")
                return false
            }
        }


        // Descontar ingredientes
        for ((ingredient, needed) in required) {
            currentStock[ingredient] = (currentStock[ingredient] ?: 0) - needed
        }


        return true
    }

    fun hasIngredients(): Boolean {
        return currentStock.all { (_, amount) -> amount > 0 }
    }
}