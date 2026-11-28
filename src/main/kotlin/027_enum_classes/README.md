# 027 — Enum Classes

An enum class defines a fixed set of named singleton values. It is useful for states or choices that all have the same shape.

## Basic syntax

```kotlin
enum class TrafficLight(val instruction: String) {
    RED("Stop"),
    YELLOW("Wait"),
    GREEN("Go"),
}
```

Each constant is an object. It can expose the enum's properties and functions.

```kotlin
val light = TrafficLight.GREEN
println(light.instruction) // Go
println(TrafficLight.entries.joinToString()) // RED, YELLOW, GREEN
```

`when` can cover every constant without `else`:

```kotlin
val message = when (light) {
    TrafficLight.RED -> "Cars stop"
    TrafficLight.YELLOW -> "Cars slow down"
    TrafficLight.GREEN -> "Cars move"
}
```

## Important rules

- `name` is the declared constant name.
- `ordinal` is its zero-based declaration position.
- Never persist `ordinal`; inserting or reordering constants changes it.
- Use a stable explicit code when saving or transmitting an enum value.
- An exhaustive `when` provides a compile-time reminder when a new constant is added.

## Interview questions

**Are enum constants integers?** No. They are singleton objects; `ordinal` is only a position.

**Why is persisting `ordinal` risky?** Declaration changes can silently change stored meanings.

**What does `entries` provide?** All enum constants in declaration order.

**When can `when` omit `else`?** When every enum constant is handled.

## Quick revision

- Enums model a fixed set of same-shaped values.
- Constants can have properties and behavior.
- Prefer `entries` to inspect all constants.
- Persist a stable code, not `ordinal`.

## Source code

[EnumClasses.kt](./EnumClasses.kt)

## Next lesson

028 — Data Classes
