# While Loop

`while` repeats while a condition is true. `do-while` executes the body before its first condition check.

## Runnable example

[WhileLoop.kt](./WhileLoop.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `while (condition) { ... }` | Pre-test loop; may execute zero times. |
| `do { ... } while (condition)` | Post-test loop; executes at least once. |
| `attempts++` | Increments by one. |

## Step-by-step walkthrough

1. The first loop prints attempts 1 through 3.
2. The polling loop first assigns `null`, then `ready`.
3. Only after each body execution is the `do-while` condition checked.

## Expected output

```text
Attempt 1
Attempt 2
Attempt 3
ready
```

## Important rules and behavior

- A loop condition must be Boolean.
- Update the state used by the condition or the loop may never finish.
- `break` exits the nearest loop; `continue` starts its next iteration.
- Loops are statements and do not produce a useful value.

## Common mistakes and edge cases

- Forgetting the increment.
- Blocking Android's main thread with a polling loop.
- Using a loop where a collection operation communicates intent better.

## Kotlin compared with Java

The syntax is similar to Java, but Kotlin conditions never coerce numbers or references to Boolean.

## Android relevance

Never perform long or blocking loops on the main thread. Use lifecycle-aware coroutines for repeated asynchronous work.

## Interview questions and answers

### 1. Which loop always runs at least once?

`do-while`, because it checks after the body.

### 2. What is the risk in this loop style?

An unchanged condition can create an infinite loop.

### 3. Do loops return collected values?

No. Build a collection explicitly or use collection operators.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
