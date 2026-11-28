# 028 — Data Classes

A data class represents a value made from related properties. Kotlin generates common operations such as readable text, value equality, copying, and component functions.

## Basic syntax

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val tags: MutableList<String>,
)
```

Primary-constructor properties participate in generated `toString()`, `equals()`, `hashCode()`, `copy()`, and `componentN()` functions.

```kotlin
val phone = Product(1, "Phone", mutableListOf("electronics"))
println(phone)
// Product(id=1, name=Phone, tags=[electronics])

val renamed = phone.copy(name = "Smartphone")
println(renamed.name) // Smartphone
```

A property declared in the class body is excluded from generated equality and copying:

```kotlin
data class Product(val id: Int) {
    var stock: Int = 0
}
```

`copy()` is shallow. Referenced mutable objects are shared unless they are copied separately.

## Important rules

- A data class needs at least one primary-constructor property.
- Primary-constructor parameters must use `val` or `var`.
- Equality compares primary-constructor properties by value.
- Body properties are ignored by generated equality and `copy()`.
- `copy()` creates a new outer object, not a deep copy.

## Interview questions

**What does a data class generate?** `equals()`, `hashCode()`, `toString()`, `copy()`, and component functions for constructor properties.

**Does `copy()` make a deep copy?** No. Nested object references are reused.

**Are body properties part of equality?** No.

**Why must `equals()` and `hashCode()` agree?** Equal objects must have equal hash codes for hash-based collections to work correctly.

## Quick revision

- Use data classes for value-like models.
- Generated behavior uses primary-constructor properties.
- `copy(name = ...)` changes selected values.
- Copying is shallow.

## Source code

[DataClasses.kt](./DataClasses.kt)

## Next lesson

029 — Destructuring Declarations
