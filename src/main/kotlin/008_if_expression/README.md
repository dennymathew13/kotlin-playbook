# if Expression

Kotlin `if` controls execution and can also produce a value, removing the need for a ternary operator.

## Runnable example

[ifExpression.kt](./ifExpression.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `if (condition)` | Evaluates a required Boolean condition. |
| `else` | Provides the alternative branch. |
| `val x = if (...) a else b` | Assigns the selected branch value. |

## Step-by-step walkthrough

1. `stock > 0` selects `In stock`.
2. `stock >= 5` is false, so the fee is `40`.
3. The final template prints both computed values.

## Expected output

```text
In stock; delivery fee=40
```

## Important rules and behavior

- Conditions must be `Boolean`; Kotlin has no truthy/falsy coercion.
- When the result is used, every path must produce a compatible value.
- A branch block evaluates to its last expression.
- Kotlin has no `condition ? a : b` ternary operator.

## Common mistakes and edge cases

- Omitting `else` when using `if` as a value.
- Writing Java-style ternary syntax.
- Putting side effects in a deeply nested expression.

## Kotlin compared with Java

Kotlin uses `if` both as control flow and as an expression; Java commonly uses a ternary expression for value selection.

## Android relevance

Useful for derived UI values such as labels and enabled state. Prefer readable state derivation over nested conditionals in composables.

## Interview questions and answers

### 1. Why is `else` required in a value-producing `if`?

The expression must have a result for every possible path.

### 2. What is the result of a branch block?

Its final expression.

### 3. Does Kotlin accept `if (1)`?

No. The condition must have type `Boolean`.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
