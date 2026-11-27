# Variables

Variables give names to values. Kotlin makes reassignment explicit with `val` and `var`, which helps communicate intent and reduce accidental state changes.

## Runnable example

[Variables.kt](./Variables.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `val cart = ...` | Creates a read-only reference; `cart` cannot point to another object. |
| `var screen = ...` | Creates a reassignable reference. |
| `cart.itemCount = 2` | Mutates a property of the object; it does not reassign `cart`. |
| `${...} / $name` | Inserts values into a string template. |

## Step-by-step walkthrough

1. `cart` refers to a mutable `Cart`.
2. Changing `itemCount` is legal because that property is a `var`.
3. `screen` changes from `Home` to `Checkout`.
4. The commented reassignment fails because `cart` is a `val`.

## Expected output

```text
2 items on Checkout
```

## Important rules and behavior

- Prefer `val`; use `var` only when reassignment is part of the design.
- Type inference is static typing, not dynamic typing.
- `val` protects the reference, not the object graph.
- A `var` property has a getter and setter; a `val` property has only a getter.

## Common mistakes and edge cases

- Saying "`val` means immutable."
- Using `var` by default as in Java.
- Confusing property mutation with reference reassignment.

## Kotlin compared with Java

A local `val` is similar to a Java `final` reference. Kotlin `var` is similar to a normal Java local variable.

## Android relevance

Immutable UI-state snapshots are easier to reason about. A `val` may still hold `MutableState`, `MutableList`, or another mutable object.

## Interview questions and answers

### 1. Does `val` make an object immutable?

No. It prevents reassignment of that reference; mutable members can still change.

### 2. Can Kotlin infer a variable type?

Yes, from the initializer, while retaining compile-time type safety.

### 3. Why prefer `val`?

It reduces possible state transitions and makes code easier to reason about and use safely across asynchronous work.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
