# 023 — Property Accessors

Properties use getters and, for `var`, setters. Custom accessors can calculate or normalize a value while keeping normal property syntax.

## Custom setter and backing field

```kotlin
var celsius: Double = celsius
    set(value) {
        field = if (value < -273.15) -273.15 else value
    }
```

Inside an accessor, `field` refers to that property's backing storage. Writing `celsius = value` inside this setter would call the setter again and recurse.

## Computed property

```kotlin
val fahrenheit: Double
    get() = celsius * 9 / 5 + 32
```

This getter calculates its result each time. It does not need its own backing field.

```kotlin
val temperature = Temperature(20.0)
temperature.celsius = 25.0
println(temperature.fahrenheit) // 77.0
```

## Important rules

- `val` has a getter; `var` has a getter and setter.
- `field` is available only inside a property accessor when backing storage exists.
- A computed property may have no backing field.
- Use `field`, not the property name, to store a value inside its setter.
- Avoid surprising side effects or expensive work in getters.

## Interview questions

**What is a backing field?** Compiler-provided storage used by a property.

**Why use `field` in a setter?** Assigning the property name would invoke the setter recursively.

**Can a `val` have a custom getter?** Yes.

**Does every property have a backing field?** No. A purely computed property does not need one.

## Quick revision

- `get()` controls reads.
- `set(value)` controls writes.
- `field` accesses stored data.
- Computed properties calculate on access.

## Source code

[PropertyAccessors.kt](./PropertyAccessors.kt)

## Next lesson

024 — Extension Functions
