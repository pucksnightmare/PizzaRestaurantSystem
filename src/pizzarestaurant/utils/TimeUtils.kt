package pizzarestaurant.utils

class TimeUtils {
    companion object {
        // Simula el paso del tiempo con un pequeño retardo (solo visual)
        fun sleepSimulated(hours: Double) {
            val millis = (hours * 100).toLong()
            Thread.sleep(millis)
        }
    }
}