package lesson028.dataclasses

data class Product(
    val id: Int,
    val name: String,
    val tags: MutableList<String>,
) {
    var stock: Int = 0
}

fun main() {
    val phone = Product(1, "Phone", mutableListOf("electronics"))
    phone.stock = 10
    println(phone) // Product(id=1, name=Phone, tags=[electronics])

    val samePhone = Product(1, "Phone", mutableListOf("electronics"))
    samePhone.stock = 99
    println(phone == samePhone) // true: body property stock is ignored.

    val renamed = phone.copy(name = "Smartphone")
    println(renamed.name) // Smartphone

    // copy() is shallow: both objects still refer to the same mutable list.
    renamed.tags += "sale"
    println(phone.tags) // [electronics, sale]
}
