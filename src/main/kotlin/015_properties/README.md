# 015 — Properties

A property represents an object's readable state. A `val` property is read-only through that property, while a `var` property can also be assigned.

## Basic syntax

```kotlin
class Account(val id: String) {
    var balance: Int = 0
}
```

`id` is initialized by the constructor and has no setter. `balance` starts at zero and can change.

```kotlin
val account = Account("A-1")
account.balance += 500

println("${account.id}: ${account.balance}") // A-1: 500

// account.id = "A-2" // Compile-time error
```

Property syntax hides accessor calls. A property may use compiler-provided accessors or custom ones, which are introduced in lesson 023.

## Important rules

- `val` provides a getter but no setter through that property.
- `var` provides both a getter and setter.
- A property is an accessor abstraction, not necessarily a field.
- A read-only property can still refer to a mutable object.
- Avoid exposing writable state when callers should not control it.

## Property versus local variable

A property belongs to an object or is declared at top level. A local variable exists inside a function or block.

## Interview questions

**Does every property have a backing field?** No. A later custom getter can compute a result without storage.

**Does `val` make an object immutable?** No. It only removes assignment through that property.

**What is the practical difference between `val` and `var` properties?** `var` has a setter; `val` does not.

## Quick revision

- Properties model state.
- `val` is read-only through its reference.
- `var` is assignable.
- Properties use getter/setter semantics.

## Source code

[Properties.kt](./Properties.kt)

## Next lesson

016 — Constructor
