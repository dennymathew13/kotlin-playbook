package lesson002.variables

// This example shows Kotlin's two kinds of variables: val and var.
fun main() {
    // val creates a read-only variable. Its value cannot be reassigned.
    val language = "Kotlin"

    // var creates a mutable variable. Its value can be changed later.
    var lessonNumber = 2

    println("I am learning $language.")
    println("This is lesson $lessonNumber.")

    // This works because lessonNumber was declared with var.
    lessonNumber = 3
    println("The next lesson will be lesson $lessonNumber.")

    // language = "Java" would cause an error because language was declared with val.
}
