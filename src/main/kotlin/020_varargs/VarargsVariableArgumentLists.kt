package lesson020.varargs

fun total(vararg prices: Int): Int = prices.sum()

fun main() {
    val prices = intArrayOf(10, 20)
    println(total(5, *prices)) // 35

    // total(prices) // Compile-time error: use * to spread IntArray.
}
