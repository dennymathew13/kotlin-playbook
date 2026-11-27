package lesson008.ifexpression
fun main() {
    val stock = 4
    val message = if (stock > 0) "In stock" else "Sold out"
    val fee = if (stock >= 5) 0 else 40
    println("$message; delivery fee=$fee") // Expected: In stock; delivery fee=40
    // val broken = if (stock > 0) "yes" // Compile-time error: missing else when used as a value.
}
