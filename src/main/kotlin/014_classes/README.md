# 014 — Classes

A class defines a type by grouping related state and behavior. Each constructor call creates an object of that type.

## Basic syntax

```kotlin
class Product(val id: Int, var price: Double) {
    fun discounted(percent: Int): Double =
        price * (100 - percent) / 100
}
```

`id` and `price` are properties. `discounted` is a member function and can use those properties.

```kotlin
val product = Product(7, 100.0)
println(product.discounted(20)) // 80.0
```

`Product(...)` calls the primary constructor. Dot syntax accesses an object's properties and functions.

## Important rules

- A class is a type; an object is one instance of that class.
- A constructor parameter becomes a property only when declared with `val` or `var`.
- Member functions can access the current object's properties.
- Kotlin classes and members are final by default.
- Keep a class focused on one clear responsibility.

## Common mistakes

- Assuming every constructor parameter is stored as a property.
- Creating public mutable properties without considering valid values.
- Treating a class as only a collection of unrelated helper functions.

## Interview questions

**Class versus object?** A class defines a type; an object is an instance with its own state.

**When is a constructor parameter a property?** When it uses `val` or `var`.

**Are Kotlin classes open for inheritance by default?** No. They are final unless marked otherwise.

## Quick revision

- `class` declares a type.
- Constructor calls create objects.
- Properties hold state.
- Member functions define behavior.

## Source code

[Classes.kt](./Classes.kt)

## Next lesson

015 — Properties
