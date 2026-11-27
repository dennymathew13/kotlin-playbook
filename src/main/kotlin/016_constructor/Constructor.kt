package lesson016.constructor
class Order(val id: Int, quantity: Int) {
    val quantity = requireNotNull(quantity.takeIf { it > 0 }) { "quantity must be positive" }
    init { println("Created order $id") }
}
fun main() {
    val order = Order(id = 10, quantity = 2)
    println(order.quantity)
    // Order(11, 0) // Runtime IllegalArgumentException from validation.
}
