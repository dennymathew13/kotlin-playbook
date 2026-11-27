# Property Accessors

Custom accessors preserve property syntax while adding validation or computation. `field` accesses compiler-generated backing storage inside an accessor.

## Runnable example

[PropertyAccessors.kt](./PropertyAccessors.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `get() = ...` | Defines a custom getter. |
| `set(value) { ... }` | Defines a custom setter. |
| `field` | Refers to the backing field inside an accessor. |
| `require(...)` | Throws `IllegalArgumentException` when its condition is false. |

## Step-by-step walkthrough

1. The initial Celsius value is stored.
2. The setter validates 25.0 and writes it through `field`.
3. The Fahrenheit getter computes from the current Celsius value.
4. No Fahrenheit backing field is needed.

## Expected output

```text
77.0
```

## Important rules and behavior

- `field` is available only inside an accessor that has backing storage.
- A computed property may have no backing field.
- A setter cannot be declared for `val`.
- Avoid expensive or surprising work in getters.

## Common mistakes and edge cases

- Writing `celsius = value` inside its setter, causing recursive calls.
- Assuming every property consumes storage.
- Using a getter for an operation with important side effects.

## Kotlin compared with Java

Kotlin groups accessors into a property declaration and exposes property syntax; JVM methods are generated as appropriate.

## Android relevance

Derived UI values can be properties, but expensive getters may run repeatedly during rendering or recomposition.

## Interview questions and answers

### 1. When is a backing field generated?

When a default accessor is used or a custom accessor references `field`.

### 2. Why use `field` in the setter?

Assigning the property name would call the setter recursively.

### 3. Can a `val` have a custom getter?

Yes; it can compute a value on every read.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
