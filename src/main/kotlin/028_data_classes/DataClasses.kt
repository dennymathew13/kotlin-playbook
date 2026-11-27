package lesson028.dataclasses

// The data keyword creates a class intended mainly for storing data.
// Kotlin automatically generates useful methods from the primary constructor properties.
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
) {
    // A property declared in the class body is not used by generated equals,
    // hashCode, toString, copy, or componentN functions.
    var stock: Int = 0
}

fun main() {
    val firstProduct = Product(id = 1, name = "Phone", price = 500)
    firstProduct.stock = 10

    // A data class gets a readable toString method automatically.
    println(firstProduct)

    // Data classes also get equals and hashCode methods based on property values.
    val sameProduct = Product(id = 1, name = "Phone", price = 500)
    println("Products are equal: ${firstProduct == sameProduct}")
    println("Hash codes are equal: ${firstProduct.hashCode() == sameProduct.hashCode()}")

    // copy creates a new object while keeping the original property values by default.
    // Named arguments can replace only the values that need to change.
    val discountedProduct = firstProduct.copy(price = 450)
    println("Original: $firstProduct")
    println("Copy: $discountedProduct")

    // stock is not a primary-constructor property, so it is not copied.
    println("Original stock: ${firstProduct.stock}, copy stock: ${discountedProduct.stock}")
}
