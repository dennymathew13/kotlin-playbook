package lesson004.operators

fun main() {
    // Arithmetic operators perform mathematical calculations.
    val firstNumber = 10
    val secondNumber = 3

    println("Addition: ${firstNumber + secondNumber}")       // + adds values.
    println("Subtraction: ${firstNumber - secondNumber}")    // - subtracts values.
    println("Multiplication: ${firstNumber * secondNumber}") // * multiplies values.
    println("Division: ${firstNumber / secondNumber}")       // / divides values.
    println("Remainder: ${firstNumber % secondNumber}")      // % returns the remainder.

    // Comparison operators compare values and return true or false.
    println("Equal: ${firstNumber == secondNumber}")              // == means equal to.
    println("Not equal: ${firstNumber != secondNumber}")          // != means not equal to.
    println("Greater than: ${firstNumber > secondNumber}")        // > means greater than.
    println("Less than: ${firstNumber < secondNumber}")           // < means less than.
    println("Greater or equal: ${firstNumber >= secondNumber}")   // >= means greater than or equal to.
    println("Less or equal: ${firstNumber <= secondNumber}")      // <= means less than or equal to.

    // Logical operators combine or reverse Boolean values.
    val isSunny = true
    val isWarm = false

    println("Sunny and warm: ${isSunny && isWarm}") // && is true when both values are true.
    println("Sunny or warm: ${isSunny || isWarm}")  // || is true when at least one value is true.
    println("Not sunny: ${!isSunny}")               // ! reverses true to false, or false to true.

    // Assignment operators assign or update the value of a variable.
    var score = 10 // = assigns the initial value.
    score += 5     // The same as score = score + 5.
    println("After +=: $score")

    score -= 3     // The same as score = score - 3.
    println("After -=: $score")

    score *= 2     // The same as score = score * 2.
    println("After *=: $score")

    score /= 4     // The same as score = score / 4.
    println("After /=: $score")

    score %= 3     // The same as score = score % 3.
    println("After %=: $score")
}
