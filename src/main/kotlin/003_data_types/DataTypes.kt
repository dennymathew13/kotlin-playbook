package lesson003.datatypes

// Kotlin can infer a value's data type, but explicit types are used here for learning.
fun main() {
    // Whole-number types have different storage sizes and value ranges.
    val smallNumber: Byte = 100
    val shortNumber: Short = 30_000
    val regularNumber: Int = 1_000_000
    val largeNumber: Long = 9_000_000_000L

    // Decimal-number types. A Float value ends with F; Double is the default.
    val decimalNumber: Float = 3.14F
    val preciseDecimal: Double = 3.1415926535

    // Char stores one character, while String stores text.
    val grade: Char = 'A'
    val message: String = "Learning Kotlin data types"

    // Boolean stores either true or false.
    val isKotlinFun: Boolean = true

    println("Byte: $smallNumber")
    println("Short: $shortNumber")
    println("Int: $regularNumber")
    println("Long: $largeNumber")
    println("Float: $decimalNumber")
    println("Double: $preciseDecimal")
    println("Char: $grade")
    println("String: $message")
    println("Boolean: $isKotlinFun")
}
