package lesson007.functions

fun main() {
    // Pass arguments to a function for its parameters to use.
    greetUser("Denny")

    // A function's return value can be stored in a variable.
    val total = addNumbers(10, 5)
    println("Total: $total")

    // The default value is used when an argument is not provided.
    introducePerson("Anu")
    introducePerson("Rahul", 28)

    // Named arguments identify parameters by name instead of only by position.
    // They can make a function call easier to read and allow the order to change.
    describeCourse(durationInWeeks = 8, courseName = "Kotlin Basics")
}

// name is a parameter. It receives the argument passed to greetUser.
fun greetUser(name: String) {
    println("Hello, $name!")
}

// Int after the parentheses is the function's return type.
// return sends the calculated value back to the calling code.
fun addNumbers(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

// age has a default argument of 18, which is used when age is omitted.
fun introducePerson(name: String, age: Int = 18) {
    println("$name is $age years old.")
}

// This function has two parameters that can be supplied using named arguments.
fun describeCourse(courseName: String, durationInWeeks: Int) {
    println("$courseName lasts for $durationInWeeks weeks.")
}
