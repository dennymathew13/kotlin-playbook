# 010 — While Loop

A `while` loop repeats while its condition is true. A `do-while` loop runs its body before checking the condition.

## `while`

```kotlin
var attempt = 1

while (attempt <= 3) {
    println("Attempt $attempt")
    attempt++
}
```

Output:

```text
Attempt 1
Attempt 2
Attempt 3
```

The condition is checked first, so a `while` body may run zero times.

## `do-while`

```kotlin
var countdown = 0

do {
    println(countdown)
    countdown--
} while (countdown > 0)
```

This prints `0` once because the condition is checked after the body.

## Important rules

- Conditions must be Boolean expressions.
- Update condition-related state or the loop may never finish.
- `break` exits the nearest loop.
- `continue` starts the next iteration.
- Use `do-while` only when one execution is always required.

## Interview questions

**Which loop always runs at least once?** `do-while`.

**Can a `while` loop run zero times?** Yes.

**What commonly causes an infinite loop?** A condition that never becomes false.

## Quick revision

- `while`: check, then run.
- `do-while`: run, then check.
- Keep loop updates obvious.
- Use `break` and `continue` sparingly.

## Source code

[WhileLoop.kt](./WhileLoop.kt)

## Next lesson

011 — For Loops and Ranges
