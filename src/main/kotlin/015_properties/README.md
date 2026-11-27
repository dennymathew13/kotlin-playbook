# Properties

A Kotlin property represents readable state and, for `var`, writable state. It is an accessor abstraction and may or may not use a backing field.

## Runnable example

[Properties.kt](./Properties.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `val id` | Read-only property with a getter. |
| `var balance` | Mutable property with getter and setter. |
| `account.balance += 500` | Reads, adds, then writes through the property. |

## Step-by-step walkthrough

1. The constructor initializes `id`.
2. `balance` starts at zero.
3. The compound assignment changes balance to 500.
4. Assigning to `id` fails because no setter exists.

## Expected output

```text
A-1: 500
```

## Important rules and behavior

- A property is not the same thing as a field.
- `val` means no setter through that property.
- A `val` can return a different computed value on each getter call.
- Public mutable state should preserve class invariants.

## Common mistakes and edge cases

- Calling every property a field.
- Assuming a `val` value must be deeply immutable.
- Exposing mutation that should remain private.

## Kotlin compared with Java

Kotlin property syntax often compiles to Java-style getter/setter methods and interoperates with JavaBean conventions.

## Android relevance

Expose read-only state publicly and keep mutable state private where possible, especially in ViewModels.

## Interview questions and answers

### 1. Property versus field?

A property is accessed through getter/setter semantics; a backing field is optional storage.

### 2. Does every property have a backing field?

No. Computed properties can have only a getter.

### 3. Can a `val` change between reads?

Yes, if its custom getter computes from changing data.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
