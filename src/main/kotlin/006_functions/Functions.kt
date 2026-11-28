package lesson006.functions

fun subtotal(price: Double, quantity: Int): Double = price * quantity

fun printReceipt(total: Double) {
    println("Total: %.2f".format(total))
}

fun main() {
    val total = subtotal(12.5, 2)
    printReceipt(total) // Total: 25.00
}
