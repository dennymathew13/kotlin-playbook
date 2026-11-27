# Varargs - Variable Argument Lists

A `vararg` parameter accepts zero or more values as one call-site parameter. The spread operator supplies values from an existing array.

## Runnable example

[VarargsVariableArgumentLists.kt](./VarargsVariableArgumentLists.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `vararg prices: Int` | Declares a variable-length parameter. |
| `total(5, 10, 20)` | Passes separate values. |
| `*prices` | Spreads an existing array into arguments. |
| `IntArray` | Primitive-specialized integer array on JVM. |

## Step-by-step walkthrough

1. `prices` contains 10 and 20.
2. `*prices` expands those elements after 5.
3. `sum` returns 35.
4. The second function joins IDs into a label.

## Expected output

```text
35
IDs: 1, 2, 3
```

## Important rules and behavior

- A function may declare only one `vararg` parameter.
- Inside the function, a vararg is an array type.
- Spreading may require an array copy; consider performance in hot paths.
- Parameters after a non-final vararg normally need named arguments.

## Common mistakes and edge cases

- Passing an array without `*`.
- Using vararg for large data that should remain a collection.
- Ignoring allocation/copy cost in frequently called code.

## Kotlin compared with Java

Kotlin varargs resemble Java `Type...`, but Kotlin requires `*` when spreading an existing array.

## Android relevance

Useful for builders, logging, and small helper APIs; avoid repeated large spreads in performance-sensitive UI work.

## Interview questions and answers

### 1. How do you pass an existing array?

Use the spread operator: `function(*array)`.

### 2. How many vararg parameters may a function have?

One.

### 3. What is a vararg inside the function?

An array (`IntArray` for `vararg Int`, `Array<T>` for reference types).

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
