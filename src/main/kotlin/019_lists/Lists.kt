package lesson019.lists

fun main() {
    val products: List<String> = listOf("Phone", "Case", "Phone")
    println(products[0]) // Phone
    println(products.size) // 3; lists keep duplicates.

    val cart: MutableList<String> = mutableListOf("Phone")
    val readOnlyCart: List<String> = cart
    cart.add("Case")
    println(readOnlyCart) // [Phone, Case]

    // readOnlyCart.add("Charger") // Compile-time error: List has no add().
}
