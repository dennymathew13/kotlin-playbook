package lesson021.sets

fun main() {
    val tags: Set<String> = setOf("kotlin", "android", "kotlin")
    println(tags) // [kotlin, android]: duplicate removed.
    println("kotlin" in tags) // true

    val selectedIds = mutableSetOf(1, 2)
    selectedIds.add(3)
    selectedIds.remove(1)
    println(selectedIds) // [2, 3]
}
