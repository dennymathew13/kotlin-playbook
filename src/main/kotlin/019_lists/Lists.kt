package lesson019.lists
fun main() {
    val products: List<String> = listOf("Phone", "Case", "Phone")
    val cart: MutableList<String> = products.toMutableList()
    cart += "Charger"
    println(products[0])
    println(cart)
    val readOnlyView: List<String> = cart
    cart.clear()
    println(readOnlyView) // []: read-only does not necessarily mean immutable.
}
