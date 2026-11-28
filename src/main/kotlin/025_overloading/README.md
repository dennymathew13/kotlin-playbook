# 025 — Overloading

Overloading gives several functions the same name but different parameter lists. Use it when the functions perform the same kind of operation for different inputs.

## Basic syntax

```kotlin
fun findOrder(id: Int): String = "Order number: $id"
fun findOrder(reference: String): String = "Order reference: $reference"
fun findOrder(id: Int, includeItems: Boolean): String = ...
```

The compiler chooses an overload from the arguments at the call site:

```kotlin
println(findOrder(42))       // Order number: 42
println(findOrder("WEB-42")) // Order reference: WEB-42
```

Functions cannot be overloaded by return type alone:

```kotlin
// fun findOrder(id: Int): String = ...
// fun findOrder(id: Int): Boolean = ... // Conflicting overload
```

The arguments are identical, so the call would not identify which function to use.

## Important rules

- Overloads need different parameter counts, types, or distinguishable parameter arrangements.
- Selection normally happens at compile time.
- Kotlin numeric types do not implicitly widen to find another overload.
- Default arguments often remove the need for convenience overloads.
- Keep the behavior of related overloads consistent.

## Overloading versus overriding

- **Overloading:** same name, different parameters, normally compile-time selection.
- **Overriding:** a subclass replaces an inherited member, using runtime dispatch.

## Interview questions

**Can functions differ only by return type?** No.

**Is overloading compile-time or runtime polymorphism?** Normally compile-time polymorphism.

**How do default arguments affect overload design?** They can replace several simple overloads.

**How is overriding different?** It requires inheritance and selects behavior from the runtime object.

## Quick revision

- Same name, different parameter lists.
- Arguments select the overload.
- Return type alone is insufficient.
- Do not overload unrelated operations.

## Source code

[Overloading.kt](./Overloading.kt)

## Next lesson

026 — `when` Expression
