package lesson030.nullabletypes

fun main() {

    // 1. Non-nullable types
    // By default, Kotlin types cannot hold null.

    val language: String = "Kotlin"

    println(language.length)

    // val invalid: String = null
    // Compile-time error: null is not allowed.


    // 2. Nullable types
    // Adding ? after a type allows it to hold null.

    val name: String? = null
    val age: Int? = null
    val isActive: Boolean? = null

    println(name)
    println(age)
    println(isActive)


    // 3. Assigning non-nullable to nullable types

    val firstName: String = "Denny"

    val nullableName: String? = firstName

    println(nullableName)

    // This is allowed because String? can hold
    // both String values and null.


    // 4. Assigning nullable to non-nullable types

    val optionalName: String? = null

    // val requiredName: String = optionalName
    // Compile-time error: optionalName could be null.

    // The Elvis operator provides a fallback value.

    val requiredName: String =
        optionalName ?: "Default Name"

    println(requiredName)


    // 5. Accessing nullable properties

    val userName: String? = null

    // println(userName.length)
    // Compile-time error: userName could be null.

    // The safe call operator ?. accesses the property
    // only when the receiver is not null.

    println(userName?.length) // null


    // 6. Null checks and smart casts

    val email: String? = "user@example.com"

    if (email != null) {

        // Kotlin knows email is not null inside this block.
        // The compiler smart-casts email to String.

        println(email.length)

    } else {

        println("Email is unavailable")
    }


    // 7. Nullable return values from a Map

    val map = mapOf(1 to "One")

    val existingValue: String? = map[1]
    val missingValue: String? = map[2]

    println(existingValue) // One
    println(missingValue)  // null

    // Map lookup returns a nullable type because
    // the requested key might not exist.


    // 8. Nullable properties in data classes

    val person = Person(
        name = "John",
        age = null
    )

    println(person.name) // John
    println(person.age)  // null

    // Name is mandatory.
    // Age is optional.


    // 9. Functions returning nullable values

    val product = findProduct(2)

    println(product) // null

    val productName = findProduct(1)

    println(productName) // Phone


    // 10. Nullable function parameters

    printName("Denny")
    printName(null)


    // 11. Nullable collection vs nullable elements

    // The list exists, but its elements may be null.

    val names: List<String?> =
        listOf("John", null, "David")

    println(names)

    // The list itself may be null,
    // but its elements cannot be null.

    val products: List<String>? = null

    println(products)

    // Both the list and its elements may be null.

    val optionalNames: List<String?>? =
        listOf("John", null)

    println(optionalNames)


    // 12. Null is different from an empty string

    val missingName: String? = null
    val emptyName: String = ""

    println(missingName == null) // true
    println(emptyName.isEmpty()) // true

    // null means no value.
    // "" means an existing String with zero characters.
}


// A nullable property represents information
// that may be unavailable.

data class Person(
    val name: String,
    val age: Int?
)


// A nullable return type tells callers that
// the requested result may not exist.

fun findProduct(id: Int): String? {
    return if (id == 1) "Phone" else null
}


// A nullable parameter accepts both
// non-null String values and null.

fun printName(name: String?) {

    if (name != null) {
        println("Name: $name")
    } else {
        println("Name is unavailable")
    }
}