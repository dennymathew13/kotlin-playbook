package lesson021.sets
data class User(val id: Int, val name: String)
fun main() {
    val tags: Set<String> = setOf("kotlin", "android", "kotlin")
    println(tags) // Duplicate removed.
    val selected = mutableSetOf(1, 2)
    selected += 3
    println(2 in selected)
    println(setOf(User(1, "Maya"), User(1, "Maya")).size) // 1
}
