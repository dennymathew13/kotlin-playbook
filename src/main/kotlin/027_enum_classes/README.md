# Enum Classes

An enum class represents a fixed, finite set of related values. Each enum constant is a singleton object of the enum type, not merely an integer or string.

Use an enum when every valid case is known in advance and every case has the same general shape: traffic lights, order states, directions, priorities, or supported environments.

## Runnable example

[EnumClasses.kt](./EnumClasses.kt)

## Declaration syntax

```kotlin
enum class TrafficLight(val color: String, val durationInSeconds: Int) {
    RED("Red", 30),
    YELLOW("Yellow", 5),
    GREEN("Green", 25);

    fun displayDetails() {
        println("$color light lasts for $durationInSeconds seconds.")
    }
}
```

| Syntax | Meaning |
|---|---|
| `enum class` | Declares a type with a fixed set of instances. |
| `RED(...)` | Declares one singleton enum constant and calls the enum constructor. |
| `val color` | Gives every constant a property. |
| `;` | Separates the constant list from later members. |
| `TrafficLight.RED` | Accesses a constant through its enum type. |

The semicolon is required only when properties, functions, nested declarations, or other members follow the constant list.

## Step-by-step walkthrough

1. `currentLight` refers to the single `TrafficLight.RED` instance.
2. Constructor arguments initialize `color` and `durationInSeconds` for that constant.
3. `displayDetails()` behaves like a normal member function.
4. `getAction` uses an exhaustive `when` covering all three constants.
5. `name` returns the declared identifier `RED`; `ordinal` returns its zero-based declaration position.
6. `TrafficLight.entries` provides all constants in declaration order.

## Expected output

```text
Current color: Red
Duration: 30 seconds
Red light lasts for 30 seconds.
Action: Stop
Name: RED, ordinal: 0
RED: Stop
YELLOW: Slow down
GREEN: Go
```

## Built-in enum members

Every enum constant inherits useful members from `Enum`:

| Member | Purpose |
|---|---|
| `name` | Exact source identifier of the constant, such as `"RED"`. |
| `ordinal` | Zero-based declaration position. |
| `compareTo` | Compares constants by declaration order. |
| `toString()` | Returns `name` unless overridden. |

The enum class also exposes `entries`, an `EnumEntries<T>` view of all constants. Older code often uses `values()`, which returns an array. Prefer `entries` in modern Kotlin when an array is unnecessary.

## Exhaustive `when`

```kotlin
fun getAction(light: TrafficLight): String = when (light) {
    TrafficLight.RED -> "Stop"
    TrafficLight.YELLOW -> "Slow down"
    TrafficLight.GREEN -> "Go"
}
```

No `else` is required because every constant is handled. If a new constant is added, the compiler points to exhaustive `when` expressions that must be updated.

Avoid adding an unnecessary `else` for an enum when each case deserves explicit behavior. A catch-all branch can silently hide newly added constants.

## Important rules and characteristics

- Every constant is created once and acts as a singleton.
- Enum constants have referential identity, so equality is straightforward.
- Constants may have constructor values, properties, and functions.
- An enum can implement interfaces.
- Individual constants can provide constant-specific class bodies and override members.
- An enum cannot extend another class because it already extends the platform enum base type.
- An enum may implement interfaces and contain nested declarations.
- Declaration order defines `ordinal` and natural comparison order.

## Do not persist `ordinal`

`ordinal` changes when constants are reordered or a new constant is inserted. It is unsafe as a database value, network value, analytics identifier, or saved-state contract.

Prefer an explicit stable property:

```kotlin
enum class OrderState(val wireValue: String) {
    CREATED("created"),
    SHIPPED("shipped")
}
```

The property expresses the external contract independently of declaration order.

## Parsing enum values

`enumValueOf<T>(name)` and Java-style `valueOf(name)` require the exact, case-sensitive constant name and throw `IllegalArgumentException` for an unknown value.

For untrusted API or user input, use safe validation rather than allowing parsing to crash:

```kotlin
val light = TrafficLight.entries.find { it.name.equals(input, ignoreCase = true) }
```

Decide explicitly whether unknown server values should produce `null`, an `UNKNOWN` constant, or a domain error.

## Enum versus alternatives

| Requirement | Usually prefer |
|---|---|
| Fixed cases with the same data shape | Enum class |
| Cases carrying different data | Sealed class or sealed interface |
| Arbitrary instances created at runtime | Regular or data class |
| Stable external text values | Explicit enum property, not `ordinal` |

## Common mistakes

- Treating constants as plain integers.
- Saving or sending `ordinal` as stable data.
- Parsing external input with `valueOf` without handling unknown values.
- Using enum `name` as a permanent API contract when names may be refactored.
- Adding a broad `else` to an otherwise exhaustive `when`.
- Choosing an enum when different cases need substantially different data.

## Kotlin compared with Java

Both Kotlin and Java enum constants are objects and may contain state and behavior. Kotlin integrates enums with expression-oriented, exhaustive `when`. Kotlin's `entries` property provides a modern allocation-conscious view, while Java and older Kotlin code commonly use `values()` arrays.

## Android relevance

Enums are useful for UI modes, sort order, navigation categories, and fixed domain states. When storing them in Room, Bundles, saved state, or network payloads, use a stable explicit value and define behavior for unknown future values.

For complex UI states such as `Loading`, `Content(data)`, and `Error(message)`, a sealed hierarchy is usually more expressive because each case carries different data.

## Interview questions and answers

### 1. Is an enum constant an integer?

No. It is a singleton object of the enum class. `ordinal` is only its declaration position.

### 2. Why should `ordinal` not be persisted?

Reordering or inserting constants changes ordinals, corrupting the meaning of stored or transmitted values.

### 3. What is the difference between `entries` and `values()`?

`entries` returns a reusable enum-entry view. `values()` returns a new array representation and is retained mainly for compatibility.

### 4. When can `when` omit `else` for an enum?

When every enum constant is covered. The compiler can then prove the expression is exhaustive.

### 5. What happens when a new enum constant is added?

Exhaustive `when` expressions without `else` stop compiling until the new case is handled. This is a useful maintenance signal.

### 6. Are enum constants singletons?

Yes. Each declared constant has one instance for that enum class loader/context.

### 7. Can enum constants have different behavior?

Yes. Constants can have their own class bodies and override abstract or open enum members, though a sealed hierarchy may be clearer for complex differences.

### 8. Enum versus sealed class?

Use an enum for a fixed set of same-shaped singleton values. Use a sealed hierarchy when cases need different properties, multiple instances, or distinct data payloads.

### 9. Is `valueOf` safe for external input?

Not by itself. It is case-sensitive and throws for unknown names. Validate or map external values explicitly.

## Practice

- Add a `FLASHING` constant and update the exhaustive `when`.
- Print every constant's `name`, `ordinal`, and duration.
- Add a stable `wireValue` property and find a constant safely from it.
- Explain why `TrafficLight.RED === TrafficLight.RED` is true.
