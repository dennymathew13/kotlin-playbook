# Functions

Functions package reusable behavior behind a name. Parameters carry input, a return type describes output, and callers can use the result.

## Runnable example

[Functions.kt](./Functions.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `fun` | Declares a function. |
| `price: Double` | A parameter name followed by its type. |
| `: Double` | The function return type. |
| `= expression` | An expression body; its value is returned. |
| `Unit` | The implicit result type when no useful value is returned. |

## Step-by-step walkthrough

1. `main` calls `subtotal(12.5, 2)`.
2. `subtotal` returns `25.0`.
3. `printReceipt` formats the number and prints it.

## Expected output

```text
Total: 25.00
```

## Important rules and behavior

- Parameters are read-only inside the function.
- A block-body function returning a value needs `return`.
- An expression-body function returns its expression automatically.
- Omitting a return type is fine for private simple expressions; explicit public API types improve stability.

## Common mistakes and edge cases

- Forgetting `return` in a value-returning block body.
- Giving a parameter and return type in Java order.
- Making a function perform unrelated work.

## Kotlin compared with Java

Kotlin supports top-level functions and expression bodies. Java usually places utility methods in classes.

## Android relevance

Pure functions are ideal for validation, mapping network models, and reducing UI state because they are easy to test.

## Interview questions and answers

### 1. What is `Unit`?

A real Kotlin type with one value, used when a function has no meaningful result.

### 2. Expression body versus block body?

An expression body uses `=` and returns that expression; a block uses braces and normally needs `return` for a value.

### 3. Are function parameters mutable?

No. Create a local variable if a calculation needs a changing value.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
