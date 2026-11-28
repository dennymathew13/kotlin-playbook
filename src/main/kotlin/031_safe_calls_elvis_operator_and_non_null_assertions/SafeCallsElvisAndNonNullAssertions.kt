package lesson031.nullhandling

fun main() {
    val nickname: String? = null

    // A safe call returns null instead of accessing a null receiver.
    println(nickname?.length) // null

    // Safe calls can be chained. The chain stops when a value is null.
    println(nickname?.uppercase()?.length) // null
    println(nickname?.lowercase().equals(null)) // true
    // The Elvis operator supplies a value when the left side is null.
    val displayName = nickname ?: "Guest"
    println(displayName) // Guest

    val nameLength = nickname?.length ?: 0
    println(nameLength) // 0

    // Elvis checks for null, not for an empty string.
    val emptyName: String? = ""
    println(emptyName ?: "Guest") // Prints an empty line.

    // !! tells the compiler to treat a nullable value as non-null.
    // Use it only when the value is guaranteed to be present.
    val language: String? = "Kotlin"
    println(language!!.length) // 6

    // println(nickname.length)
    // Compile-time error: nickname may be null.

    // println(nickname!!.length)
    // Runtime error: !! throws NullPointerException when nickname is null.
}
