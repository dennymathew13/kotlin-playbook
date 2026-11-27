# Extension Functions

An extension function provides member-like call syntax for an existing type without inheritance, wrapping, or modifying that type.

## Runnable example

[ExtensionFunctions.kt](./ExtensionFunctions.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `fun User.displayName()` | Declares `User` as the extension receiver. |
| `this` | Refers to the receiver when needed. |
| `value.displayName()` | Calls the extension with member-like syntax. |
| `fun Screen.kind()` | An extension selected from the declared receiver type. |

## Step-by-step walkthrough

1. `displayName` combines user properties.
2. `maskEmail` reuses a standard string operation.
3. `describe` accepts a variable declared as `Screen`.
4. Static extension resolution therefore chooses `Screen.kind`, even though the object is a `HomeScreen`.

## Expected output

```text
Maya Rao
***@example.com
Screen
```

## Important rules and behavior

- Extensions do not add members to a class.
- Resolution is static from the declared receiver type.
- A real member with the same applicable signature always wins.
- Extensions can access only members visible to ordinary callers.
- Nullable receiver extensions are possible with `Type?`.

## Common mistakes and edge cases

- Expecting virtual dispatch like an overridden member.
- Creating overly broad "utility dumping ground" extensions.
- Hiding important side effects behind harmless-looking call syntax.

## Kotlin compared with Java

On the JVM, extensions compile to static methods whose receiver is the first parameter. Java calls the generated static method.

## Android relevance

Useful for focused conversions and framework helpers. Keep extensions cohesive, discoverable, and free of hidden lifecycle assumptions.

## Interview questions and answers

### 1. How are extension functions resolved?

Statically, using the declared receiver type and imports/scope.

### 2. Member versus extension with the same signature?

The member wins.

### 3. Can an extension access private members?

No. It has no special access to the receiver's internals.

### 4. Do extensions modify the original class?

No; they are compile-time call syntax over ordinary functions.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
