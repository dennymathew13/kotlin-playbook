package lesson019.collections

fun main() {
    // A List stores ordered values and allows duplicate elements.
    val fruits: List<String> = listOf("Apple", "Banana", "Apple")
    println("List: $fruits")
    println("First fruit: ${fruits[0]}")

    // A Set stores unique values, so duplicate elements are removed.
    val uniqueFruits: Set<String> = setOf("Apple", "Banana", "Apple")
    println("Set: $uniqueFruits")

    // A Map stores key-value pairs. Each key must be unique.
    val studentScores: Map<String, Int> = mapOf(
        "Denny" to 90,
        "Anu" to 85,
    )
    println("Map: $studentScores")
    println("Denny's score: ${studentScores["Denny"]}")

    // listOf, setOf, and mapOf create read-only collection views.
    // Mutable collections allow elements to be added, changed, and removed.
    val mutableFruits: MutableList<String> = mutableListOf("Apple", "Banana")
    mutableFruits.add("Orange")
    mutableFruits[0] = "Mango"
    mutableFruits.remove("Banana")
    println("Mutable list: $mutableFruits")

    val mutableNumbers: MutableSet<Int> = mutableSetOf(1, 2, 3)
    mutableNumbers.add(4)
    mutableNumbers.add(4) // Sets ignore duplicate values.
    mutableNumbers.remove(1)
    println("Mutable set: $mutableNumbers")

    val mutableAges: MutableMap<String, Int> = mutableMapOf(
        "Denny" to 25,
        "Anu" to 22,
    )
    mutableAges["Rahul"] = 28 // Add a new key-value pair.
    mutableAges["Denny"] = 26 // Update the value for an existing key.
    mutableAges.remove("Anu")
    println("Mutable map: $mutableAges")

    // Collections can be visited with a for loop.
    for (fruit in mutableFruits) {
        println("Fruit: $fruit")
    }
}
