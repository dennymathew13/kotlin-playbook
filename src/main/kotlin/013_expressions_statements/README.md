# Expressions and Statements

An expression produces a value; a statement performs an action without becoming a value. This distinction explains why Kotlin can assign results from `if`, `when`, `try`, and blocks.

## Runnable example

[ExpressionsandStatements.kt](./ExpressionsandStatements.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `val grade = if (...) ...` | Uses an `if` expression as an initializer. |
| `run { ... }` | Executes a block and returns its final expression. |
| `val next = ...` | A declaration statement inside the block. |

## Step-by-step walkthrough

1. The `if` expression evaluates to `A`.
2. `run` creates `next` and returns the final string.
3. Assignment cannot be used as a value, as shown by the commented error.

## Expected output

```text
A; Next score: 83
```

## Important rules and behavior

- `if`, `when`, and `try` can produce values.
- Assignments are statements, preventing accidental assignment inside conditions.
- A block's last expression determines its value.
- Loops do not produce useful values.

## Common mistakes and edge cases

- Trying to chain assignments as in some languages.
- Forgetting a final expression in a value-producing block.
- Calling every line an expression.

## Kotlin compared with Java

Kotlin is more expression-oriented. Java historically treats constructs such as `if` and `try` primarily as statements.

## Android relevance

Expression-oriented state reducers make "input state → output state" transformations concise and testable.

## Interview questions and answers

### 1. Is assignment an expression in Kotlin?

No. It is a statement and cannot be used as a Boolean condition or returned value.

### 2. What is a block's value?

The value of its last expression.

### 3. Why is expression-oriented code useful?

It can compute immutable results directly and reduce temporary mutable state.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
