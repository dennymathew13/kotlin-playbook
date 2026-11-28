# 012 — `in` Keyword

The `in` keyword is used for membership tests and iteration. It reads naturally: a value is in a collection or a loop visits values in a range.

## Membership

```kotlin
val allowedRoles = setOf("admin", "editor")

println("admin" in allowedRoles) // true
println(11 !in 1..10) // true
```

- `value in container` checks membership.
- `value !in container` checks that the value is absent.

For collections and ranges, membership uses their `contains` operation.

## Iteration

```kotlin
for (number in 1..3) {
    println(number)
}
```

Output:

```text
1
2
3
```

Here, `in` separates the loop variable from the values being visited.

## Important rules

- The meaning of `in` depends on context: membership or iteration.
- `!in` is available for membership, not for loop syntax.
- Range endpoints created with `..` are included.
- The checked value's type must be supported by the container's membership operation.

## Interview questions

**What does `x in values` mean?** It checks whether `values` contains `x`.

**What does `!in` mean?** It negates a membership check.

**Is `in` only for ranges?** No. Collections and other types with a suitable `contains` operation support it.

## Quick revision

- `in` checks membership.
- `!in` checks absence.
- `for (item in values)` iterates.
- `1..3` includes both endpoints.

## Source code

[MembershipAndIteration.kt](./MembershipAndIteration.kt)

## Next lesson

013 — Expressions and Statements
