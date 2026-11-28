# Kotlin Playbook

A practical Kotlin/JVM learning repository based on the original Udemy course sequence. Each implemented technical lesson uses a small runnable example, concise notes, expected output, common rules, and interview-focused revision.

## Build and run

Requirements: JDK 21. The Gradle wrapper is included.

```powershell
.\gradlew.bat build
```

On macOS or Linux, use `./gradlew build`.

To run an example, open its Kotlin file in IntelliJ IDEA and run its `main` function. Every technical example is independent.

## Course roadmap

`Guide` marks non-coding course setup. `Complete` means the lesson has been reviewed and, where technical, has a runnable example. Later lessons remain pending even if draft files are present.

| Lesson | Topic | Status |
|---:|---|---|
| 001 | [Introduction](src/main/kotlin/001_introduction/README.md) | Guide |
| 002 | [Download and Install IntelliJ IDEA](src/main/kotlin/002_download_and_install_intellij_idea/README.md) | Guide |
| 003 | [Hello World](src/main/kotlin/003_hello_world/README.md) | Complete |
| 004 | [Variables](src/main/kotlin/004_variables/README.md) | Complete |
| 005 | [Data Types](src/main/kotlin/005_data_types/README.md) | Complete |
| 006 | [Functions](src/main/kotlin/006_functions/README.md) | Complete |
| 007 | [Default and Named Arguments](src/main/kotlin/007_default_named_arguments/README.md) | Complete |
| 008 | [`if` Expression](src/main/kotlin/008_if_expression/README.md) | Complete |
| 009 | [String Templates and Triple-Quoted Strings](src/main/kotlin/009_string_templates_triple_quoted_strings/README.md) | Complete |
| 010 | [While Loop](src/main/kotlin/010_while_loop/README.md) | Complete |
| 011 | [For Loops and Ranges](src/main/kotlin/011_for_loop_ranges/README.md) | Complete |
| 012 | [`in` Keyword](src/main/kotlin/012_in_keyword/README.md) | Complete |
| 013 | [Expressions and Statements](src/main/kotlin/013_expressions_statements/README.md) | Complete |
| 014 | [Classes](src/main/kotlin/014_classes/README.md) | Complete |
| 015 | [Properties](src/main/kotlin/015_properties/README.md) | Complete |
| 016 | [Constructor](src/main/kotlin/016_constructor/README.md) | Complete |
| 017 | [Visibility Modifiers](src/main/kotlin/017_visibility_modifiers/README.md) | Complete |
| 018 | [Packages and Imports](src/main/kotlin/018_packages_imports/README.md) | Complete |
| 019 | [Lists](src/main/kotlin/019_lists/README.md) | Complete |
| 020 | [Varargs](src/main/kotlin/020_varargs/README.md) | Complete |
| 021 | [Sets](src/main/kotlin/021_sets/README.md) | Complete |
| 022 | [Maps](src/main/kotlin/022_maps/README.md) | Complete |
| 023 | [Property Accessors](src/main/kotlin/023_property_accessors/README.md) | Complete |
| 024 | [Extension Functions](src/main/kotlin/024_extension_functions/README.md) | Complete |
| 025 | [Overloading](src/main/kotlin/025_overloading/README.md) | Complete |
| 026 | [`when` Expression](src/main/kotlin/026_when_expression/README.md) | Complete |
| 027 | [Enum Classes](src/main/kotlin/027_enum_classes/README.md) | Complete |
| 028 | [Data Classes](src/main/kotlin/028_data_classes/README.md) | Complete |
| 029 | [Destructuring Declarations](src/main/kotlin/029_destructuring_declarations/README.md) | Complete |
| 030 | [Nullable Types](src/main/kotlin/030_nullable_types/README.md) | Complete |

## Pending course lessons

- 031–040: null handling, generics, extensions, scope functions, lambdas, collection operations, member references, higher-order functions, and working with lists and maps.
- 041–050: sequences, local functions, folds, interfaces, constructors, inheritance, abstract classes, casting, composition, and delegation.
- 051–060: sealed and nested types, objects, companions, exceptions, checks, and unit testing.
- 061–064: course project lessons.
- 065–070: asynchronous programming and coroutine fundamentals.
- 071–079: Kotlin Flow, sharing, and channels.
- 080: Final Word.

Supplementary subjects after the original course roadmap remain pending and are outside the reviewed 001–030 foundation.
