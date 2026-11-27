package lesson017.extensionfunctions

// String is the receiver type of this extension function.
// Inside the function, this refers to the String that called it.
fun String.addGreeting(): String {
    return "Hello, $this!"
}

class Rectangle(val width: Double, val height: Double)

// Extension functions add callable behavior without inheritance or modifying the class.
fun Rectangle.calculateArea(): Double {
    return width * height
}

// An extension property adds a computed property to an existing type.
// Extension properties cannot store state, so they must use a getter.
val String.firstCharacter: Char
    get() = this[0]

// An extension can use a nullable receiver type such as String?.
// It can safely handle both a String value and null.
fun String?.orDefault(): String {
    return this ?: "Unknown"
}

fun main() {
    // Call an extension function like a regular member function.
    val name = "Denny"
    println(name.addGreeting())

    // Rectangle does not inherit from another class to gain calculateArea.
    val rectangle = Rectangle(width = 4.0, height = 5.0)
    println("Rectangle area: ${rectangle.calculateArea()}")

    // Access an extension property using dot notation.
    val language = "Kotlin"
    println("First character: ${language.firstCharacter}")

    // Nullable extensions can be called even when the receiver is null.
    val userName: String? = null
    println("User name: ${userName.orDefault()}")

    val anotherUserName: String? = "Anu"
    println("User name: ${anotherUserName.orDefault()}")
}
