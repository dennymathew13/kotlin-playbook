# 003 — Hello World

A Kotlin/JVM program can start from a top-level `main` function. This first example prints one line to the console.

## Program

```kotlin
fun main() {
    println("Hello, Kotlin!")
}
```

Output:

```text
Hello, Kotlin!
```

## What happens

1. The runtime starts the `main` function.
2. Statements run from top to bottom.
3. `println` writes the text and then a line break.

## Syntax

- `fun` declares a function.
- `main` is the recognized entry-point name.
- `{}` contains the function body.
- Double quotes create a string.
- `println(...)` calls a function.

## Important rules

- Kotlin names are case-sensitive: `main` and `Main` differ.
- A JVM entry point can be a top-level function; no source class is required.
- Use double quotes for strings and single quotes for a single `Char`.

## Interview questions

**Is `main` a Kotlin keyword?** No. It is a specially recognized function name and signature.

**Can Kotlin have top-level functions?** Yes.

**What does `println` return?** `Unit`, because it has no useful result value.

## Quick revision

- Execution starts at `main`.
- `fun` declares a function.
- `println` writes a line.
- Strings use double quotes.

## Source code

[HelloWorld.kt](./HelloWorld.kt)

## Next lesson

004 — Variables
