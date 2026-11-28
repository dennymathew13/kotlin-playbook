package lesson014.classes

class Product(val id: Int, var price: Double) {
    fun discounted(percent: Int): Double = price * (100 - percent) / 100
}

fun main() {
    val product = Product(7, 100.0)
    println(product.discounted(20)) // 80.0
}
