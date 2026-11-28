package lesson030.nullabletypes

fun main() {

    // 1. Nullable and non-nullable types
    val language: String = "Kotlin"
    val name: String? = null

    println(language.length) // 6
    println(name) // null

    // val invalid: String = null
    // Compile-time error: String cannot hold null.


    // 2. Assignment rules
    val firstName: String = "Denny"
    val nullableName: String? = firstName // Allowed

    // val requiredName: String = name
    // Compile-time error: name could be null.


    // 3. Safe call operator (?.)
    // Returns null if the receiver is null.

    println(name?.length) // null

    // println(name.length) // Compile-time error


    // 4. Elvis operator (?:)
    // Provides a fallback when the value is null.

    val displayName: String = name ?: "Default Name"

    println(displayName) // Default Name


    // 5. Null check and smart casting
    val email: String? = "user@example.com"

    if (email != null) {
        // Kotlin treats email as a non-nullable String.
        println(email.length) // 16
    }


    // 6. Nullable Map results
    // Map lookup returns String? because a key may not exist.

    val map = mapOf(1 to "One")

    println(map[1]) // One
    println(map[2]) // null


    // 7. Nullable properties in data classes
    val person = Person("John", null)

    println(person.name) // John
    println(person.age)  // null
}

// Name cannot be null, but age can be null.
data class Person(
    val name: String,
    val age: Int?
)