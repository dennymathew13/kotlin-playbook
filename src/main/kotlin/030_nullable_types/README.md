# 030 — Nullable Types

## 1. Introduction

Imagine an Android application receives a user profile from a backend API.

The profile contains a name, email address and phone number.

However, the user may not have provided a phone number.

How should the application represent this missing information?

We could use an empty string, but an empty string and an unavailable value are not necessarily the same thing.

Programming languages use `null` to represent the absence of a value.

The problem occurs when we try to access a property or call a method on a null reference. This can cause a NullPointerException.

Kotlin addresses this problem through its null-safety type system.

## 2. Source code

Runnable example: [NullableTypes.kt](./NullableTypes.kt)

## 3. Non-nullable types

By default, Kotlin types cannot contain null.

```kotlin
val name: String = "Denny"
val age: Int = 30
val active: Boolean = true
```

These variables must contain values of their declared types.

The following is invalid:

```kotlin
val name: String = null
```

This produces a compile-time error.

Kotlin detects the problem before the application runs.

## 4. Nullable types

Adding a question mark after a type makes it nullable.

```kotlin
val name: String? = null
val age: Int? = null
val active: Boolean? = null
```

The question mark means that the variable can contain either a value of the specified type or null.

| Type | Allowed values |
|---|---|
| String | Non-null String |
| String? | String or null |
| Int | Non-null Int |
| Int? | Int or null |
| Boolean | true or false |
| Boolean? | true, false or null |

Think of nullable and non-nullable types as different sets of possible values.

```text
String
    ├── "Kotlin"
    ├── "Java"
    └── ""

String?
    ├── "Kotlin"
    ├── "Java"
    ├── ""
    └── null
```

Every String is also a valid String?, but not every String? is a valid String.

## 5. Nullable types and assignment

### Non-nullable to nullable

This is allowed:

```kotlin
val name: String = "Denny"
val optionalName: String? = name
```

String? can hold everything that String can hold, plus null.

### Nullable to non-nullable

This is not directly allowed:

```kotlin
val optionalName: String? = null

// val name: String = optionalName
```

The compiler cannot guarantee that optionalName contains a non-null value.

| Assignment | Allowed? |
|---|---|
| String to String | Yes |
| String to String? | Yes |
| String? to String? | Yes |
| String? to String | Not without establishing or providing a non-null value |
| null to String | No |
| null to String? | Yes |

## 6. Why direct property access is restricted

Consider:

```kotlin
val name: String? = null

println(name.length)
```

This produces a compile-time error.

Why?

The length property belongs to String. If name is null, there is no String object whose length can be accessed.

Kotlin forces the developer to handle this possibility.

Common solutions include:

- Explicit null checks.
- Safe call operator.
- Elvis operator.
- Non-null assertions, when justified.

The operators are covered in detail in Lesson 031.

## 7. Null checks and smart casts

The simplest way to handle nullable values is to check whether they are null.

```kotlin
val name: String? = "Denny"

if (name != null) {
    println(name.length)
}
```

Output:

```text
5
```

Inside the if block, the compiler knows that name cannot be null.

It automatically treats name as a non-nullable String.

This is called a smart cast.

```text
name: String?
      |
      v
Is name != null?
      |
      +-- Yes --> Treat as String
      |
      +-- No ---> Handle missing value
```

Smart casts require the compiler to establish that the value remains stable between the check and its use.

They may not be possible for mutable properties, properties with custom getters or values that could change unexpectedly.

For example:

```kotlin
class User(var name: String?)

fun printLength(user: User) {
    val name = user.name

    if (name != null) {
        println(name.length)
    }
}
```

Capturing the property in a local val gives the compiler a stable value to check.

## 8. Safe call operator — preview

The safe call operator is written as `?.`.

```kotlin
val name: String? = null

println(name?.length)
```

Output:

```text
null
```

If name contains a String, Kotlin accesses its length.

If name is null, the property access is skipped and the expression returns null.

```kotlin
val name: String? = "Kotlin"

val length: Int? = name?.length

println(length)
```

Output:

```text
6
```

Notice that the result has a nullable type because the operation might return null.

## 9. Elvis operator — preview

The Elvis operator is written as `?:`.

It provides an alternative value when the expression on its left is null.

```kotlin
val name: String? = null

val displayName: String =
    name ?: "Default Name"
```

Output:

```text
Default Name
```

The resulting value can be assigned to String because both possible outcomes are non-null Strings.

The Elvis operator does not change the original variable.

It produces a result using either the original value or the fallback.

## 10. Nullable values in Maps

Consider a map containing product identifiers and names.

```kotlin
val products = mapOf(
    1 to "Phone",
    2 to "Laptop"
)

val product = products[3]
```

The result is null because key 3 does not exist.

The return type of the lookup is String?.

Even though the map contains non-nullable String values, a lookup might fail to find a key.

```kotlin
val existing: String? = products[1]
val missing: String? = products[3]
```

Results:

```text
existing = Phone
missing  = null
```

Important distinction:

The Map API returns null for a missing key. The compiler does not catch an exception and replace it with null.

If a map permits nullable values, containsKey() can distinguish a missing key from a key explicitly mapped to null.

## 11. Nullable properties in data classes

Nullable types are particularly useful when representing real-world information.

```kotlin
data class Person(
    val name: String,
    val age: Int?
)
```

Create an instance:

```kotlin
val person = Person(
    name = "John",
    age = null
)
```

The name is required, but the age may be unavailable.

```kotlin
println(person.name)
println(person.age)
```

Output:

```text
John
null
```

Use nullable properties when missing information is a valid part of the domain model.

Do not make every property nullable merely for convenience.

## 12. Nullable function parameters

A nullable parameter allows callers to supply either a valid value or null.

```kotlin
fun printName(name: String?) {
    if (name != null) {
        println(name)
    } else {
        println("Name is unavailable")
    }
}
```

Both calls are valid:

```kotlin
printName("Denny")
printName(null)
```

A non-nullable parameter communicates a stronger requirement:

```kotlin
fun printName(name: String) {
    println(name)
}
```

This function requires a non-null String.

Choose parameter nullability according to what the function actually supports.

## 13. Nullable function return types

A function can explicitly communicate that its result might not exist.

```kotlin
fun findProduct(id: Int): String? {
    return if (id == 1) "Phone" else null
}
```

Usage:

```kotlin
val product = findProduct(2)
```

The result is null.

The caller must account for the possibility that no product was found.

This makes the function's contract clearer than returning an arbitrary empty string or undocumented special value.

## 14. Nullable collections versus nullable elements

This is an important Kotlin interview topic.

The position of the question mark determines what can be null.

| Type | Collection can be null? | Elements can be null? |
|---|---|---|
| List<String> | No | No |
| List<String?> | No | Yes |
| List<String>? | Yes | No |
| List<String?>? | Yes | Yes |

### Non-nullable collection with non-nullable elements

```kotlin
val names: List<String> =
    listOf("John", "David")
```

Neither the list reference nor its elements can be null.

### Non-nullable collection with nullable elements

```kotlin
val names: List<String?> =
    listOf("John", null, "David")
```

The list exists, but individual elements may be null.

### Nullable collection with non-nullable elements

```kotlin
val names: List<String>? = null
```

The entire list may be unavailable.

If it exists, its elements must be non-null Strings.

### Nullable collection with nullable elements

```kotlin
val names: List<String?>? =
    listOf("John", null)
```

Both the list reference and individual elements may be null.

### Memory trick

```text
List<String?>?
           | |
           | +-- List can be null
           |
           +---- Elements can be null
```

## 15. Null versus empty versus blank

These are different concepts.

```kotlin
val missing: String? = null
val empty: String = ""
val blank: String = "   "
```

| Value | Meaning |
|---|---|
| null | No String value |
| "" | String containing zero characters |
| "   " | String containing whitespace |
| "Kotlin" | String containing text |

Useful Kotlin functions include:

```kotlin
name.isNullOrEmpty()
name.isNullOrBlank()
```

isNullOrEmpty() checks for null or zero characters.

isNullOrBlank() checks for null, zero characters or whitespace-only content.

These are particularly useful for validating user input.

## 16. Kotlin versus Java

In traditional Java, reference types may generally contain null.

```java
String name = null;

System.out.println(name.length());
```

This compiles but throws a NullPointerException at runtime.

In Kotlin:

```kotlin
val name: String? = null

// println(name.length)
```

The unsafe property access is rejected at compile time.

| Java | Kotlin |
|---|---|
| Reference types can generally hold null | Types are non-nullable by default |
| Nullability often expressed through annotations | Nullability is part of the type system |
| Unsafe access may compile | Many unsafe accesses are rejected |
| Explicit null checks commonly used | Null checks, smart casts and null-safety operators |

Java annotations and static analysis tools can also provide nullability checking, but Kotlin integrates nullability directly into its language type system.

## 17. Does Kotlin completely eliminate NullPointerException?

No.

Kotlin significantly reduces accidental null-related errors, but NullPointerException is still possible.

Examples include:

- Incorrect use of the non-null assertion operator.
- Explicitly throwing a NullPointerException.
- Unsafe interaction with Java platform types.
- Certain object initialization inconsistencies.
- External Java code violating nullability contracts.

Null safety reduces risk. It does not guarantee that every program is free from null-related runtime errors.

## 18. Java interoperability and platform types

Java code does not always provide reliable nullability information.

When Kotlin calls certain Java APIs, the compiler may not know whether the returned value can be null.

Such types are called platform types.

IDE tools may display a platform type as:

```text
String!
```

The exclamation mark is IDE/type-display notation, not ordinary Kotlin source syntax.

For example:

```kotlin
val result = javaService.getName()
```

If the Java method has no reliable nullability information, Kotlin may allow the result to be treated as either nullable or non-nullable.

This introduces a potential runtime risk.

A defensive approach is to explicitly use a nullable type when the Java API contract is uncertain.

```kotlin
val result: String? = javaService.getName()
```

Platform types will be covered in greater depth during Java interoperability.

## 19. Nullable primitive-like types on the JVM

Consider:

```kotlin
val count: Int = 10
val optionalCount: Int? = null
```

On the JVM, a non-nullable Int can often be represented using a primitive int.

A nullable Int must be capable of representing null, so it generally uses a boxed Integer representation.

```text
Int   --> JVM int where possible
Int?  --> JVM Integer reference
```

Boxing may introduce allocation or memory overhead, although actual allocation depends on caching and runtime optimizations.

This is JVM-specific behaviour, not a universal rule for every Kotlin platform.

## 20. Android and backend development relevance

Nullable types are commonly used for:

- Optional API response fields.
- Missing database values.
- Optional user profile information.
- Search results that may not exist.
- Android Intent extras.
- Optional UI content.
- Java and Android framework interoperability.

Example:

```kotlin
data class UserProfile(
    val id: Int,
    val name: String,
    val email: String?,
    val phone: String?
)
```

The model clearly communicates that id and name are mandatory while email and phone may be unavailable.

In larger applications, null should not represent every possible application state.

For example, a null result might ambiguously mean loading, failure or missing data.

A dedicated state model, such as a sealed hierarchy, can communicate these different states more clearly.

## 21. Best practices

- Prefer non-nullable types when a value is required.
- Use nullable types when missing information is valid.
- Handle null at an appropriate application boundary.
- Use smart casts when a simple null check is sufficient.
- Avoid unnecessary non-null assertions.
- Do not confuse null with empty strings or empty collections.
- Provide meaningful fallback values rather than hiding errors.
- Be careful with Java platform types.
- Use explicit state models when null would have several ambiguous meanings.

## 22. Common mistakes

| Mistake | Explanation |
|---|---|
| Assigning null to String | Compile-time error |
| Directly accessing a nullable receiver | Compiler rejects unsafe access |
| Assuming map lookup is always non-null | The requested key may be missing |
| Confusing List<String?> with List<String>? | Different nullability guarantees |
| Assuming null and empty are equivalent | They represent different states |
| Making every property nullable | Weakens the domain model |
| Assuming Kotlin prevents every NPE | Unsafe operations and interoperability can still cause exceptions |
| Using meaningless fallback values | Can hide invalid application state |

## 23. Interview questions and answers

### 1. What is a nullable type in Kotlin?

A type that permits null in addition to its normal values. It is declared by adding ? after the type.

### 2. What is the difference between String and String??

String cannot contain null. String? can contain either a String or null.

### 3. Can a non-nullable value be assigned to a nullable variable?

Yes. A nullable type accepts all values of its corresponding non-nullable type.

### 4. Can a nullable value be directly assigned to a non-nullable variable?

No, unless the compiler can establish that the expression is non-null. Otherwise, an appropriate null-handling operation is required.

### 5. What is smart casting?

The compiler automatically treats a stable value as a more specific type after a successful type or null check.

### 6. Why might a smart cast fail for a mutable property?

The compiler cannot always guarantee that the property will retain the same value between the check and its use.

### 7. Why does Map lookup return a nullable value?

The requested key might not exist, even if the map's declared value type is non-nullable.

### 8. What is the difference between List<String?> and List<String>??

List<String?> is a non-null list containing potentially nullable elements.

List<String>? is a potentially nullable list containing non-null elements.

### 9. Does Kotlin completely eliminate NullPointerException?

No. Non-null assertions, Java interoperability and certain initialization issues can still cause null-related runtime exceptions.

### 10. What is a platform type?

A type originating from an interoperability context, such as Java, where Kotlin does not have definitive nullability information.

### 11. What is the difference between Int and Int? on the JVM?

Int can often use a primitive int representation. Int? generally requires a boxed Integer representation to support null.

### 12. What is the difference between null, empty and blank?

Null means no value. Empty means zero characters. Blank means zero characters or whitespace-only content.

### 13. When should a property be nullable?

When the absence of its value is a valid and meaningful state in the application domain.

### 14. Does the Elvis operator modify the original nullable variable?

No. It produces either the original non-null value or a fallback result.

### 15. Why should we avoid making every field nullable?

It weakens compile-time guarantees, increases null-handling requirements and makes application state harder to reason about.

## 24. Practice exercises

1. Declare nullable String, Int and Boolean variables.
2. Attempt to assign a nullable String to a non-nullable String and explain the error.
3. Use a null check and smart cast to access a nullable String's length.
4. Create a map and look up a missing key.
5. Create a User data class with mandatory and optional properties.
6. Write a function that returns null when an employee is not found.
7. Explain the four possible collection nullability combinations.
8. Compare null, empty and blank strings.

## 25. Quick revision

```text
String  = Cannot contain null
String? = Can contain null

Non-nullable --> Nullable
Allowed

Nullable --> Non-nullable
Requires a proven or supplied non-null value

if (value != null)
Can enable smart casting

?. = Safe call
?: = Fallback value

Map lookup can return null.

List<String?> = Nullable elements
List<String>? = Nullable list

Null is not the same as empty.

Kotlin reduces NPEs but does not eliminate them.
```

**Memory trick:** The question mark after a type tells you that its value might be missing.

## References

- https://kotlinlang.org/docs/null-safety.html
- https://kotlinlang.org/docs/typecasts.html
- https://kotlinlang.org/docs/java-interop.html

## Next lesson

031 — Safe Calls, Elvis Operator and Non-Null Assertions

The next lesson explores null-handling operators, safe call chains, fallback evaluation and the risks of forcing nullable values to become non-nullable.