package lesson016.constructor

class Order(val id: Int, quantity: Int) {
    val quantity: Int = quantity

    init {
        println("Created order $id")
    }
}

fun main() {
    val order = Order(id = 10, quantity = 2)
    println(order.quantity) // 2
}
