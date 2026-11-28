# 029 — Destructuring Declarations

## 1. Introduction

Imagine you have an object containing several values, and you want to store those values in separate variables.

Normally, you would write:

```kotlin
val name = person.firstName
val age = person.age
val address = person.address
```

Kotlin allows you to simplify this using a destructuring declaration:

```kotlin
val (name, age, address) = person
```

Destructuring means extracting multiple values from an object into separate local variables using a single declaration.

It reduces repetitive property access and makes code more readable when working with related values.

## 2. Source code

Runnable example: [DestructuringDeclarations.kt](./DestructuringDeclarations.kt)

## 3. Basic syntax

```kotlin
val (first, second, third) = object
```

- `val` declares read-only local variables.
- `var` can be used when the extracted variables need reassignment.
- Parentheses group the variables being declared.
- Each variable receives the corresponding component from the object.

Destructuring does not automatically work with every object. The object must provide suitable `operator componentN()` functions.

## 4. Destructuring a Pair

A Pair holds two values, which may have different types.

```kotlin
val pair = Pair(1, "Denny")
```

Traditional approach:

```kotlin
val id = pair.first
val name = pair.second
```

Destructuring approach:

```kotlin
val (id, name) = pair

println(id)
println(name)
```

Output:

```text
1
Denny
```

Pair is useful for returning two related values from a function.

However, when the values have important business meanings, a named data class is often clearer than Pair.

## 5. Destructuring a Triple

Triple holds three values.

```kotlin
val product = Triple(101, "Phone", 500)

val (id, name, price) = product
```

The extracted values are:

| Variable | Value | Type |
|---|---|---|
| id | 101 | Int |
| name | Phone | String |
| price | 500 | Int |

Prefer a data class when representing meaningful domain information that needs descriptive properties.

## 6. Destructuring a data class

```kotlin
data class Person(
    val firstName: String,
    val age: Int,
    val address: String
)

val person = Person(
    firstName = "Denny",
    age = 30,
    address = "123 Main St"
)

val (name, age, address) = person
```

Output:

```text
name = Denny
age = 30
address = 123 Main St
```

Kotlin automatically generates component functions for properties declared in the primary constructor of a data class.

## 7. How destructuring works internally

Consider:

```kotlin
val (name, age, address) = person
```

Conceptually, the compiler translates this into:

```kotlin
val name = person.component1()
val age = person.component2()
val address = person.component3()
```

The original expression is evaluated once.

Component mapping:

```text
Person
  |
  |-- firstName --> component1() --> name
  |
  |-- age -------> component2() --> age
  |
  |-- address ---> component3() --> address
```

The number in componentN corresponds to the component's position.

For data classes, this position follows the primary constructor property declaration order.

## 8. Order matters, not variable names

```kotlin
data class Person(val name: String, val age: Int)

val person = Person("Denny", 30)

val (age, name) = person
```

Despite the variable names:

```text
age  = Denny
name = 30
```

The compiler uses component positions, not the meaning of the variable names.

The inferred type of age is String, while the inferred type of name is Int.

This is an important interview trap.

Use meaningful variable names that match the component order.

## 9. Ignoring components using underscore

Sometimes you need only one value from an object.

```kotlin
val (_, age, _) = person

println(age)
```

Output:

```text
30
```

The underscore tells Kotlin to ignore that component.

Importantly, Kotlin does not call the corresponding componentN() function for a skipped component.

This matters if a custom component function performs expensive work or has side effects.

## 10. Partial destructuring

You do not need to extract every component.

```kotlin
val (name, age) = person
```

Only the first two components are extracted.

However, requesting more components than the object supports causes a compile-time error.

```kotlin
val pair = Pair(1, "Denny")

// val (a, b, c) = pair
```

Pair does not provide component3().

## 11. Destructuring maps

Maps contain key-value entries.

```kotlin
val prices = mapOf(
    "Phone" to 500,
    "Laptop" to 1000
)

for ((product, price) in prices) {
    println("$product costs $price")
}
```

Output:

```text
Phone costs 500
Laptop costs 1000
```

Each map entry supports destructuring into its key and value through component functions provided by the Kotlin standard library.

Conceptually:

```kotlin
for (entry in prices) {
    val product = entry.key
    val price = entry.value

    println("$product costs $price")
}
```

## 12. Destructuring lambda parameters

Destructuring can also be used in lambda parameters.

```kotlin
prices.forEach { (product, price) ->
    println("$product costs $price")
}
```

The parentheses indicate that one incoming object is being destructured into multiple variables.

This differs from a lambda receiving two independent parameters.

```kotlin
{ (a, b) -> ... } // One destructured parameter

{ a, b -> ... }   // Two separate parameters
```

Lambdas are covered in more detail in a later lesson.

## 13. Destructuring withIndex()

Sometimes you need both the position and the element while iterating over a collection.

```kotlin
val products = listOf("Phone", "Laptop", "Tablet")

for ((index, product) in products.withIndex()) {
    println("$index: $product")
}
```

Output:

```text
0: Phone
1: Laptop
2: Tablet
```

withIndex() provides indexed values containing an index and an element.

These values support destructuring.

## 14. Destructuring regular classes

Destructuring is not restricted to data classes.

A regular class can support destructuring by defining appropriate operator componentN() functions.

```kotlin
class Point(
    private val x: Int,
    private val y: Int
) {
    operator fun component1(): Int = x

    operator fun component2(): Int = y
}

val point = Point(10, 20)

val (x, y) = point
```

Output:

```text
x = 10
y = 20
```

The operator modifier allows these functions to participate in Kotlin's destructuring convention.

Suitable extension componentN() functions can also provide destructuring support.

This demonstrates that destructuring is a language convention based on functions, rather than a feature exclusive to data classes.

## 15. Primary constructor properties versus body properties

Data classes generate component functions only for primary constructor properties.

```kotlin
data class Product(
    val id: Int,
    val name: String
) {
    var stock: Int = 0
}
```

Generated components:

| Function | Value |
|---|---|
| component1() | id |
| component2() | name |
| component3() | Not automatically generated |

The stock property is excluded because it is declared inside the class body.

This follows the same rule discussed in the Data Classes lesson.

## 16. Does destructuring modify the original object?

No.

```kotlin
val pair = Pair(1, "Denny")

var (id, name) = pair

id = 100
name = "John"

println(pair)
```

Output:

```text
(1, Denny)
```

The extracted variables are independent local variables.

Reassigning them does not modify the original object.

However, destructuring does not perform a deep copy.

If an extracted component refers to a mutable object, both the original object and the extracted variable may refer to the same mutable object.

```kotlin
data class Cart(val items: MutableList<String>)

val cart = Cart(mutableListOf("Phone"))

val (items) = cart

items.add("Laptop")

println(cart.items)
```

Output:

```text
[Phone, Laptop]
```

The reference was extracted, not the underlying list copied.

## 17. Destructuring collections directly

Kotlin also provides component functions for arrays and lists.

```kotlin
val numbers = listOf(10, 20, 30)

val (first, second) = numbers
```

However, the compiler generally cannot guarantee that the collection contains enough elements.

```kotlin
val numbers = listOf(10)

val (first, second) = numbers
```

This compiles, but attempting to access the second element throws an IndexOutOfBoundsException.

For collections with uncertain sizes, validate their size or use safe indexed access such as getOrNull().

## 18. Compile-time versus runtime errors

| Situation | Result |
|---|---|
| Requesting component3() from Pair | Compile-time error |
| Destructuring a regular class without suitable component functions | Compile-time error |
| Extracting more list elements than actually exist | Runtime exception |
| Using misleading variable names | Compiles, but may cause logical mistakes |
| Ignoring a component with underscore | Valid |
| Extracting fewer components | Valid |

## 19. Advantages

- Reduces repetitive property access.
- Makes map iteration concise.
- Simplifies handling multiple related return values.
- Improves readability when component order is obvious.
- Supports data classes and custom classes.

## 20. Limitations and trade-offs

Destructuring is positional, so changing the order of constructor properties can change its meaning.

For example:

```kotlin
data class User(
    val firstName: String,
    val lastName: String
)
```

If the constructor properties are reordered, existing destructuring declarations may silently receive different values because both components have the same type.

For large or frequently changing data models, explicit property access may be safer and more readable.

Avoid destructuring many properties when the reader must inspect the class declaration to understand their meaning.

## 21. Kotlin versus Java

Traditional Java code usually extracts object values using accessor methods.

```java
String name = person.getFirstName();
int age = person.getAge();
```

Kotlin:

```kotlin
val (name, age) = person
```

Modern Java supports record patterns in appropriate pattern-matching contexts, but Kotlin provides general component-function-based destructuring declarations.

Kotlin destructuring also integrates directly with loops, maps and lambda parameters.

## 22. Android development relevance

### Iterating over UI items

```kotlin
for ((index, item) in products.withIndex()) {
    println("$index: $item")
}
```

### Processing configuration entries

```kotlin
settings.forEach { (key, value) ->
    println("$key = $value")
}
```

### Extracting related values from a data model

```kotlin
data class UserDetails(
    val name: String,
    val email: String
)

val (name, email) = userDetails
```

For larger Android UI state models, prefer explicit property access when it communicates the meaning more clearly.

## 23. Interview questions and answers

### 1. What is destructuring in Kotlin?

Extracting multiple components from an object into separate local variables using a single declaration.

### 2. How does destructuring work internally?

The compiler uses operator functions named component1(), component2(), component3(), and so on.

### 3. Is destructuring limited to data classes?

No. Any type with suitable accessible operator componentN() functions can support destructuring.

### 4. Does the variable name determine which property is extracted?

No. Component order determines which value is extracted.

### 5. What does underscore mean in destructuring?

It skips the corresponding component. Its component function is not called.

### 6. Can we destructure only some properties?

Yes. We can extract the first few components or skip intermediate components using underscores.

### 7. Are data class body properties included in generated destructuring functions?

No. Automatically generated component functions correspond to primary constructor properties.

### 8. Does destructuring create a copy of the object?

No. It extracts component values. Mutable referenced objects may still be shared.

### 9. Can we use var instead of val?

Yes. The extracted local variables can then be reassigned independently.

### 10. What happens when a Pair is destructured into three variables?

A compile-time error occurs because Pair does not provide component3().

### 11. Can destructuring cause a runtime exception?

Yes. For example, destructuring a list into more variables than it contains can cause an IndexOutOfBoundsException.

### 12. What is the difference between destructuring and copy()?

Destructuring extracts values into local variables.

copy() creates a new data class instance using existing or replacement constructor-property values.

### 13. Can component functions be extension functions?

Yes. Suitable operator extension functions can provide destructuring support for existing types.

### 14. When should you avoid destructuring?

Avoid it when component order is unclear, the object has many properties, or explicit property access communicates intent better.

## 24. Practice exercises

1. Create a Pair containing an employee ID and name. Destructure both values.
2. Create a Product data class containing id, name and price.
3. Extract only the price using underscores.
4. Reverse the names of destructured variables and predict their values.
5. Create a regular Rectangle class supporting component1() and component2().
6. Destructure a map using a for loop and a lambda.
7. Predict what happens when a list containing one element is destructured into two variables.
8. Destructure a mutable list property and explain whether modifying the extracted list affects the original object.

## 25. Quick revision

```text
Destructuring = Extract multiple component values

val (a, b) = object

a = object.component1()
b = object.component2()

_ = Skip a component

Order matters, not variable names.

Data class components:
Primary constructor properties only.

Regular class:
Define operator componentN() functions.

Destructuring does not perform a deep copy.
```

**Memory trick:** Destructuring unpacks an object's components; it does not destroy, modify or automatically copy the object.