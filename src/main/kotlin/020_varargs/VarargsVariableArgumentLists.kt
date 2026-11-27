package lesson020.varargs
fun total(vararg prices: Int): Int = prices.sum()
fun label(prefix: String, vararg ids: Int): String = "$prefix: ${ids.joinToString()}"
fun main() {
    val prices = intArrayOf(10, 20)
    println(total(5, *prices)) // Expected: 35
    println(label("IDs", 1, 2, 3))
    // total(prices) // Compile-time error: use * to spread IntArray.
}
