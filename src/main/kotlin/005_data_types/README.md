# 005 — Data Types

A type defines which values a variable can hold and which operations are valid. Kotlin is statically typed, even when the compiler infers a type.

## Common types

```kotlin
val quantity: Int = 3
val orderId: Long = 9_000_000_000L
val price: Double = 19.99
val rating: Float = 4.5F
val initial: Char = 'K'
val available: Boolean = true
val language: String = "Kotlin"
```

- `Int` and `Long` store whole numbers.
- `Float` and `Double` store floating-point numbers.
- `Char` stores one character; `String` stores text.
- `Boolean` is either `true` or `false`.

Suffixes distinguish some literals: `L` creates a `Long`, and `F` creates a `Float`. Underscores make large numbers readable without changing their value.

## Explicit numeric conversion

Kotlin does not implicitly widen numeric variables:

```kotlin
val quantity: Int = 3
val widened: Long = quantity.toLong()

// val invalid: Long = quantity // Compile-time type mismatch
```

## Important rules

- Type inference still produces a fixed compile-time type.
- `Double` is the default type for decimal literals.
- Integer division drops the fractional remainder.
- Numeric conversion is explicit with functions such as `toLong()`.
- Floating-point numbers are not suitable for exact money calculations.

## Interview questions

**Why does Kotlin require explicit numeric conversion?** It avoids silent precision and overload-resolution surprises.

**Is inferred code dynamically typed?** No. The compiler determines a static type.

**What is the difference between `Char` and `String`?** `Char` is one character value; `String` is a sequence of characters.

## Quick revision

- Use an appropriate type for the value's range and meaning.
- `L` marks `Long`; `F` marks `Float`.
- Convert numbers explicitly.
- Type inference does not remove type safety.

## Source code

[DataTypes.kt](./DataTypes.kt)

## Next lesson

006 — Functions
