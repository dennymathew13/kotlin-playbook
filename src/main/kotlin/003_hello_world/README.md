# Hello World

A Kotlin program starts from an entry-point function. This smallest example shows a function declaration, a function call, a string literal, and console output.

## Runnable example

[HelloWorld.kt](./HelloWorld.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `fun` | Declares a function. |
| `main` | The conventional JVM entry-point name. |
| `()` | The function takes no arguments in this example. |
| `println(...)` | Writes a value followed by a platform line separator. |

## Step-by-step walkthrough

1. The JVM launcher finds `main`.
2. Execution enters the function body.
3. `println` receives the string `"Hello, Kotlin!"` and writes it.

## Expected output

```text
Hello, Kotlin!
```

## Important rules and behavior

- `main` is a function name, not a Kotlin keyword.
- Kotlin does not require an enclosing class in source.
- Statements execute from top to bottom.

## Common mistakes and edge cases

- Writing `Main` instead of `main`; names are case-sensitive.
- Using single quotes for text; single quotes create a `Char`.

## Kotlin compared with Java

Java normally requires `public static void main(String[] args)` inside a class. Kotlin permits a top-level function; on the JVM the compiler generates a file class.

## Android relevance

Android components are launched by the framework rather than this `main`, but the function and call syntax is the same.

## Interview questions and answers

### 1. Is `main` a keyword?

No. `fun` is a keyword; `main` is a specially recognized function name/signature.

### 2. What does `println` return?

`Unit`, meaning it performs an action without returning a useful result.

### 3. Can Kotlin have top-level functions?

Yes. On the JVM they compile to static methods in a generated file class.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
