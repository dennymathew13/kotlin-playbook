# Constructor

Constructors establish an object's initial state. Kotlin's primary constructor sits in the class header; property initializers and `init` blocks perform initialization and validation.

## Runnable example

[Constructor.kt](./Constructor.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `class Order(val id: Int, quantity: Int)` | Declares a primary constructor; only `id` becomes a property here. |
| `init { ... }` | Runs during construction. |
| `takeIf { it > 0 }` | Returns the value only when the predicate is true. |
| `requireNotNull(...)` | Throws `IllegalArgumentException` when the value is null. |

## Step-by-step walkthrough

1. Constructor arguments become available to initializers.
2. The `quantity` property validates the parameter.
3. The `init` block prints the creation message.
4. The constructed object exposes quantity 2.

## Expected output

```text
Created order 10
2
```

## Important rules and behavior

- Property initializers and `init` blocks execute in textual order.
- Construction should leave an object valid or throw.
- Primary-constructor parameters without `val`/`var` are not properties.
- Throwing validation exceptions is a runtime behavior.

## Common mistakes and edge cases

- Doing network or long-running work in a constructor.
- Reading a property before its earlier dependencies are initialized.
- Confusing a constructor parameter with a stored property.

## Kotlin compared with Java

Primary constructors and `init` reduce Java constructor boilerplate. Kotlin also supports secondary constructors when needed.

## Android relevance

Constructor injection is useful for ordinary classes. Framework-created Activities and Fragments must follow Android instantiation/lifecycle constraints.

## Interview questions and answers

### 1. What executes first: initializer or `init` block?

They execute in the order they appear in the class body.

### 2. Can a primary constructor contain statements?

Not directly; use property initializers and `init` blocks.

### 3. What happens for quantity zero in this example?

Construction throws `IllegalArgumentException`; no valid `Order` is returned.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
