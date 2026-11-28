package lesson004.variables

class Cart(var itemCount: Int)

fun main() {
    val cart = Cart(1)
    cart.itemCount = 2 // val protects the reference, not the mutable object.

    var screen = "Home"
    screen = "Checkout"

    println("${cart.itemCount} items on $screen") // 2 items on Checkout

    // cart = Cart(0) // Compile-time error: val cannot be reassigned.
}
