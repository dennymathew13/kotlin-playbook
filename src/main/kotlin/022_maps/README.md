# Maps

A map associates unique keys with values. It supports direct lookup and clearly models relationships such as product code to price.

## Runnable example

[Maps.kt](./Maps.kt)

## Syntax

| Syntax | Meaning |
|---|---|
| `Map<K, V>` | Read-only key/value interface. |
| `key to value` | Builds a `Pair` used by map factories. |
| `map[key]` | Indexing syntax for `get(key)`. |
| `getOrDefault(key, value)` | Returns a fallback for an absent key. |
| `containsKey(key)` | Checks key presence independently of its value. |

## Step-by-step walkthrough

1. The phone price lookup returns 500.
2. The absent charger uses default 0.
3. Both an absent key and a key mapped to null return null from `get`.
4. `containsKey` distinguishes the mapped-to-null case.

## Expected output

```text
500
0
known value=null
missing value=null
true
```

## Important rules and behavior

- Keys are unique; adding the same key replaces its associated value in mutable maps.
- `get` returning null can mean absent or mapped to null.
- Hash-map keys require stable equality/hash behavior.
- Read-only does not necessarily mean immutable.

## Common mistakes and edge cases

- Using `map[key] != null` as a presence test when nullable values are allowed.
- Using mutable keys in hash maps.
- Using string-keyed maps where a typed model is clearer.

## Kotlin compared with Java

Kotlin adds indexing, `to` factories, and separate read-only/mutable interfaces over familiar JVM map concepts.

## Android relevance

Maps suit caches and lookup tables; typed data classes are usually safer for saved state, navigation data, and UI models.

## Interview questions and answers

### 1. How do you distinguish missing from mapped-to-null?

Use `containsKey`.

### 2. What does `a to b` create?

A `Pair`, which `mapOf` consumes as a key/value entry.

### 3. Can map keys be mutable?

They can, but changing equality/hash state after insertion can break lookup.

## Practice

- Predict the output before running the example.
- Explain every commented compile-time or runtime error.
- Change one input and explain whether the behavior changes at compile time or runtime.
