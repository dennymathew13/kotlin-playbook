# Classes

A class defines a type by grouping state and behavior. Instances of `Product` hold product data and know how to calculate a discounted price.

## Runnable example

[Classes.kt](./Classes.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `class Product(...)` | Declares a class and primary constructor. |
| `val id: Int` | Creates a read-only property. |
| `var price: Double` | Creates a mutable property. |
| `fun discounted(...)` | Declares a member function. |
| `Product(7, 100.0)` | Constructs an instance. |

## Step-by-step walkthrough

1. The constructor creates a product with ID 7 and price 100.
2. `discounted(20)` computes 80 percent of the price.
3. The result is printed.

## Expected output

```text
80.0
```

## Important rules and behavior

- Kotlin classes are final by default.
- A constructor parameter becomes a property only with `val` or `var`.
- Member functions can access instance properties.
- Keep responsibilities cohesive; a class should model one clear concept.

## Common mistakes and edge cases

- Assuming every constructor parameter is a property.
- Adding `open` without a real inheritance requirement.
- Using mutable public properties without invariants.

## Kotlin compared with Java

Kotlin can declare constructor, properties, and accessors in one concise header. Java generally needs explicit fields and methods.

## Android relevance

Classes model repositories, use cases, state holders, and UI models. Framework-owned components have additional lifecycle rules.

## Interview questions and answers

### 1. Are Kotlin classes open by default?

No. Classes and overridable members must be marked `open` unless abstract.

### 2. When is a constructor parameter a property?

Only when declared with `val` or `var`.

### 3. Class versus object?

A class is a blueprint; each constructor call creates an instance with its own state.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
