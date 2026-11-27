package lesson005.datatypes
fun main() {
    val quantity: Int = 3
    val orderId: Long = 9_000_000_000L
    val price: Double = 19.99
    val rating: Float = 4.5F
    val initial: Char = 'K'
    val available: Boolean = true
    val total = quantity * price
    println("$initial order $orderId: $total, available=$available, rating=$rating")
    val widened: Long = quantity.toLong() // Explicit numeric conversion.
    println(widened)
    // val invalid: Long = quantity // Compile-time type mismatch.
}
