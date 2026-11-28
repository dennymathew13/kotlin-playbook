# 030 — Nullable Types

Kotlin types are non-nullable by default. Adding `?` after a type allows it to contain null.

## 1. Nullable vs Non-nullable Types

```kotlin
val name: String = "Denny"
val optionalName: String? = null

// val name: String = null // Compile-time error
```

- `String` — Cannot contain null.
- `String?` — Can contain a String or null.

## 2. Assignment Rules

```kotlin
val name: String = "Denny"
val optionalName: String? = name // Allowed
```

A non-nullable value can be assigned to a nullable variable. The reverse requires null handling.

```kotlin
val name: String? = null
val result: String = name ?: "Default Name"
```

The Elvis operator (`?:`) provides a fallback when the value is null.

## 3. Accessing Nullable Values

Direct property access on a potentially null value is not allowed.

```kotlin
val name: String? = null

// println(name.length) // Compile-time error

println(name?.length) // null
```

The safe call operator (`?.`) accesses the property only when the receiver is non-null. Otherwise, it returns null.

## 4. Null Checks and Smart Casting

```kotlin
val name: String? = "Denny"

if (name != null) {
    println(name.length) // 5
}
```

After the null check, Kotlin automatically treats the stable variable as a non-nullable String. This is called **smart casting**.

## 5. Nullable Map Results

```kotlin
val map = mapOf(1 to "One")

val result = map[2]

println(result) // null
```

The result is of type `String?` because the requested key might not exist.

Returning null is the behaviour of the Map API, not the compiler catching an exception.

## 6. Nullable Properties in Data Classes

```kotlin
data class Person(
    val name: String,
    val age: Int?
)

val person = Person("John", null)
```

Here, name is mandatory, while age can be unavailable.

## Essential Interview Questions

**What is a nullable type?**

A type that allows null, declared using `?`.

**What is smart casting?**

The compiler automatically treats a stable nullable value as non-nullable after a successful null check.

**Why does Map lookup return a nullable type?**

Because the requested key might not exist.

**Does Kotlin completely eliminate NullPointerException?**

No. Incorrect use of `!!` and unsafe Java interoperability can still cause NPEs.

## Quick Revision

- `String` — Non-nullable.
- `String?` — Nullable.
- `?.` — Safe property or function access.
- `?:` — Provides a fallback.
- `!= null` — Null check that can enable smart casting.

## Source Code

[NullableTypes.kt](./NullableTypes.kt)

## Next Lesson

031 — Safe Calls, Elvis Operator and Non-Null Assertions