# Packages and Imports

Packages provide namespaces. Imports allow concise references, and aliases resolve collisions or clarify intent.

## Runnable example

[PackagesandImports.kt](./PackagesandImports.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `package lesson018.packagesimports` | Declares the file's namespace. |
| `import kotlin.math.roundToInt as rounded` | Imports a declaration with a local alias. |
| `4.6.rounded()` | Calls the imported extension through its alias. |

## Step-by-step walkthrough

1. The compiler resolves `rounded` to `roundToInt`.
2. The extension rounds 4.6 to the nearest integer.
3. The program prints 5.

## Expected output

```text
5
```

## Important rules and behavior

- A package declaration need not match directories, though matching is strongly recommended.
- Imports affect name resolution; they do not copy code.
- Kotlin can import functions and properties directly.
- Wildcard imports do not recursively import subpackages.

## Common mistakes and edge cases

- Using directory structure as proof of a package declaration.
- Adding unnecessary wildcard imports.
- Using aliases that make a familiar API harder to recognize.

## Kotlin compared with Java

Kotlin imports top-level declarations directly and supports `as` aliases. Java uses static imports and lacks the same alias syntax.

## Android relevance

Consistent package structure matters for maintainability, manifests, generated code, and module APIs.

## Interview questions and answers

### 1. Must folders match a package?

No compiler requirement, but matching is a strong convention.

### 2. What does `as` do?

It gives an imported declaration a different name in that file.

### 3. Do imports add runtime cost?

No. They are compile-time name-resolution directives.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
