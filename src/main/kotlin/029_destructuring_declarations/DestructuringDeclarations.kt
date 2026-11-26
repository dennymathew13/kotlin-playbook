package lesson029.destructuringdeclarations

fun main() {

    // 1. Destructuring a Pair
    // Pair holds two values, which may have different types.

    val pair = Pair(first = 1, second = "Denny")

    // Traditional way of accessing values.
    println(pair.first)
    println(pair.second)

    // Destructuring extracts values into separate local variables.
    val (id, name) = pair

    println("ID: $id, Name: $name")


    // 2. Destructuring a Triple
    // Triple holds three values.

    val triple = Triple(101, "Phone", 500)

    val (productId, productName, price) = triple

    println("Product: $productId, $productName, $price")


    // 3. Destructuring a data class

    val person = Person(
        firstName = "Denny",
        age = 30,
        address = "123 Main St"
    )

    // Traditional property access.
    println(person.firstName)
    println(person.age)
    println(person.address)

    // Extract multiple properties into local variables.
    val (firstName, age, address) = person

    println("Name: $firstName, Age: $age, Address: $address")


    // 4. Internal working of destructuring
    // Data classes automatically generate componentN() functions
    // for properties declared in their primary constructor.
    //
    // Destructuring follows property declaration order,
    // not the names of the local variables.

    println("Component 1: ${person.component1()}")
    println("Component 2: ${person.component2()}")
    println("Component 3: ${person.component3()}")

    // Internally, the destructuring above is equivalent to:
    val extractedName = person.component1()
    val extractedAge = person.component2()
    val extractedAddress = person.component3()

    println("$extractedName, $extractedAge, $extractedAddress")


    // 5. Ignoring unnecessary values
    // The underscore (_) skips a component.
    // Kotlin does not call componentN() for skipped components.

    val (_, personAge, _) = person

    println("Age: $personAge")


    // 6. Partial destructuring
    // You do not need to extract every available component.

    val (onlyName, onlyAge) = person

    println("$onlyName is $onlyAge years old")


    // 7. Variable names do not determine component selection.
    // Destructuring is positional.

    val (wronglyNamedAge, wronglyNamedName) = person

    println(wronglyNamedAge)  // Denny (String)
    println(wronglyNamedName) // 30 (Int)


    // 8. Destructuring map entries
    // Each map entry provides a key and a value.

    val map = mapOf(
        "key1" to "value1",
        "key2" to "value2"
    )

    for ((key, value) in map) {
        println("Key: $key, Value: $value")
    }


    // 9. Destructuring in lambda parameters

    map.forEach { (key, value) ->
        println("$key = $value")
    }


    // 10. Destructuring a list with its index

    val products = listOf("Phone", "Laptop", "Tablet")

    for ((index, product) in products.withIndex()) {
        println("$index: $product")
    }


    // 11. Destructuring a regular class
    // A class does not have to be a data class.
    // It only needs suitable operator componentN() functions.

    val point = Point(10, 20)

    val (x, y) = point

    println("X: $x, Y: $y")


    // 12. Destructuring does not modify the original object.
    // The extracted variables are separate local variables.

    var (number, userName) = pair

    number = 100
    userName = "John"

    println("Local values: $number, $userName")
    println("Original pair: $pair")


    // 13. Common mistake: requesting too many components.
    // Pair only supports component1() and component2().

    // val (a, b, c) = pair
    // Compile-time error: component3() is unavailable.
}


// Data class automatically generates component1(),
// component2() and component3() in constructor order.

data class Person(
    val firstName: String,
    val age: Int,
    val address: String
)


// Regular class with manually defined component functions.

class Point(
    private val x: Int,
    private val y: Int
) {
    operator fun component1(): Int = x

    operator fun component2(): Int = y
}