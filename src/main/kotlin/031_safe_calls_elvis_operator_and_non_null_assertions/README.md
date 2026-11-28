# 031 — Safe Calls, Elvis Operator, and Non-Null Assertions

Nullable values must be handled before their properties or functions can be used. Kotlin provides `?.`, `?:`, and `!!` for different null-handling situations.

## Safe calls

The safe-call operator `?.` accesses a value only when it is not null:

```kotlin
val nickname: String? = null

println(nickname?.length) // null
```

If `nickname` is null, the expression returns null instead of accessing `length`. Safe calls can be chained:

```kotlin
println(nickname?.uppercase()?.length) // null
```

The chain stops as soon as one receiver is null.

## Elvis operator

The Elvis operator `?:` provides a fallback when the expression on its left is null:

```kotlin
val displayName = nickname ?: "Guest"
println(displayName) // Guest

val nameLength = nickname?.length ?: 0
println(nameLength) // 0
```

Elvis checks only for null. An empty string is still a non-null value:

```kotlin
val emptyName: String? = ""
println(emptyName ?: "Guest") // Prints an empty line
```

## Non-null assertion

The non-null assertion `!!` tells the compiler to treat a nullable value as non-null:

```kotlin
val language: String? = "Kotlin"
println(language!!.length) // 6
```

If the value is null, `!!` throws `NullPointerException`. Prefer safe calls, Elvis, or a null check whenever possible.

## Important rules

- `?.` returns null when its receiver is null.
- A safe-call chain stops at the first null value.
- `?:` uses its right side only when the left side is null.
- `?:` does not treat `""`, `0`, or `false` as missing values.
- `!!` bypasses Kotlin's null-safety check and can fail at runtime.

## Interview questions

**What does a safe call return when its receiver is null?** Null.

**When is the right side of Elvis evaluated?** Only when the left side evaluates to null.

**Does Elvis replace an empty string with its fallback?** No. An empty string is non-null.

**What happens when `!!` is used on null?** It throws `NullPointerException`.

## Quick revision

- `value?.property` — access safely.
- `nullable ?: fallback` — replace null with a fallback.
- `value!!` — assert non-null; unsafe when the guarantee is wrong.
- Prefer explicit null handling over `!!`.

## Source code

[SafeCallsElvisAndNonNullAssertions.kt](./SafeCallsElvisAndNonNullAssertions.kt)

## Next lesson

032 — Generics
