package lesson029.destructuringdeclarations

data class Person(val name: String, val age: Int)

fun main() {
    val user = 7 to "Maya"
    val (id, userName) = user
    println("$id: $userName") // 7: Maya

    val person = Person("Arun", 30)
    val (name, age) = person
    println("$name is $age") // Arun is 30

    // Destructuring uses component functions in declaration order.
    println(person.component1()) // Arun
    println(person.component2()) // 30

    val (_, onlyAge) = person // _ skips a component that is not needed.
    println(onlyAge) // 30

    val prices = mapOf("Phone" to 500, "Case" to 20)
    for ((product, price) in prices) {
        println("$product: $price")
    }

    // val (first, second, third) = user
    // Compile-time error: Pair has no component3().
}
