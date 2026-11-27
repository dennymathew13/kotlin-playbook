# Kotlin Playbook

A structured Kotlin/JVM learning and interview reference for Java developers moving toward Android development. The lesson numbering follows the supplied Udemy curriculum.

## Running the examples

Requirements: JDK 21 and the included Gradle wrapper. Open a Kotlin file in IntelliJ IDEA or Android Studio and run its `main` function.

```powershell
.\gradlew.bat compileKotlin
.\gradlew.bat test
.\gradlew.bat build
```

On macOS or Linux, use `./gradlew`.

## Documented lessons

Each implemented lesson includes runnable code, syntax explanations, an execution walkthrough, expected output, edge cases, Java comparisons, Android relevance, and interview questions with answers.

| Lesson | Topic | Notes and examples |
|---:|---|---|
| 001 | Introduction | [Open](src/main/kotlin/001_introduction/README.md) |
| 002 | Download and Install IntelliJ IDEA | [Open](src/main/kotlin/002_download_and_install_intellij_idea/README.md) |
| 003 | Hello World | [Open](src/main/kotlin/003_hello_world/README.md) |
| 004 | Variables | [Open](src/main/kotlin/004_variables/README.md) |
| 005 | Data Types | [Open](src/main/kotlin/005_data_types/README.md) |
| 006 | Functions | [Open](src/main/kotlin/006_functions/README.md) |
| 007 | Default and Named Arguments | [Open](src/main/kotlin/007_default_named_arguments/README.md) |
| 008 | if Expression | [Open](src/main/kotlin/008_if_expression/README.md) |
| 009 | String Templates and Triple-Quoted Strings | [Open](src/main/kotlin/009_string_templates_triple_quoted_strings/README.md) |
| 010 | While Loop | [Open](src/main/kotlin/010_while_loop/README.md) |
| 011 | For Loop and Ranges | [Open](src/main/kotlin/011_for_loop_ranges/README.md) |
| 012 | in Keyword | [Open](src/main/kotlin/012_in_keyword/README.md) |
| 013 | Expressions and Statements | [Open](src/main/kotlin/013_expressions_statements/README.md) |
| 014 | Classes | [Open](src/main/kotlin/014_classes/README.md) |
| 015 | Properties | [Open](src/main/kotlin/015_properties/README.md) |
| 016 | Constructor | [Open](src/main/kotlin/016_constructor/README.md) |
| 017 | Visibility Modifiers | [Open](src/main/kotlin/017_visibility_modifiers/README.md) |
| 018 | Packages and Imports | [Open](src/main/kotlin/018_packages_imports/README.md) |
| 019 | Lists | [Open](src/main/kotlin/019_lists/README.md) |
| 020 | Varargs - Variable Argument Lists | [Open](src/main/kotlin/020_varargs/README.md) |
| 021 | Sets | [Open](src/main/kotlin/021_sets/README.md) |
| 022 | Maps | [Open](src/main/kotlin/022_maps/README.md) |
| 023 | Property Accessors | [Open](src/main/kotlin/023_property_accessors/README.md) |
| 024 | Extension Functions | [Open](src/main/kotlin/024_extension_functions/README.md) |

## Remaining course sequence

025 Overloading · 026 `when` Expression · 027 Enum Classes · 028 Data Classes · 029 Destructuring Declarations · 030 Nullable Types · 031 Safe Calls, Elvis Operator and Non-Null Assertions · 032 Generics · 033 Extension Properties · 034 Scope Functions · 035 Lambdas · 036 Collection Operations · 037 Member References · 038 Higher-Order Functions · 039 Working with Lists · 040 Working with Maps · 041 Working with Sequences · 042 Local Functions · 043 Folding Lists · 044 Interfaces · 045 Secondary Constructors · 046 Inheritance · 047 Abstract Classes · 048 Upcasting and Downcasting · 049 Composition · 050 Class Delegation · 051 Sealed Classes · 052 Nested Classes · 053 Inner Classes · 054 Object · 055 Companion Object · 056 Sealed Interfaces · 057 Exceptions · 058 Catching an Exception · 059 Check Instructions · 060 Unit Testing · 061 Introducing the Project · 062 Tic-Tac-Toe Game · 063 Project Source Code · 064 Tic-Tac-Toe Update · 065 Traditional Asynchronous Programming · 066 Coroutines and Suspension · 067 Coroutine Builders · 068 Jobs · 069 Cancellation · 070 Coroutine Exceptions · 071 Cold Kotlin Flows · 072 Flow Builders · 073 Flow Operators · 074 Flow Error Handling · 075 Hot Kotlin Flows · 076 Hot Flow Sharing Strategies · 077 Compose State vs StateFlow · 078 StateFlow vs SharedFlow · 079 Channels · 080 Final Word.

## Supplementary interview roadmap

Future supplementary subjects include equality, smart casts, type aliases, delegated properties, generic variance, inline and reified functions, Java interoperability, JVM annotations, structured concurrency, coroutine synchronization, testing, platform types, and Kotlin/JVM performance.

## Technical scope

The repository distinguishes Kotlin language rules, standard-library contracts, JVM implementation details, and Android-specific guidance. Android frameworks such as Compose, ViewModel, Room, networking, and dependency injection belong in a dedicated application project after the related Kotlin foundations.
