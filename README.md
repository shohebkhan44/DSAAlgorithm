# DSAAlgorithm

A small collection of Data Structures & Algorithms practice problems implemented in Java. The repository groups solutions by topic (arrays, linked lists, sorting, searching, strings, recursion, hashing and more). Each source file contains one or more problem implementations and small test/demo code in `main`.

## Repository structure (high level)

- Array problems: `ArrayDSA.java`, `Arraymedium.java`, `Arrayhard.java`, `arsumchat.java`
- Searching / Binary Search: `BinarySearch.java`, `BinarySearchAnswers.java`
- Sorting & algorithms: `SortingAlgo.java`
- Linked lists: `LinkedLiastMedium.java`, `linkedList.java`, `LinkedListIntro.java`, `DoublyLL.java`, `DLLmedium.java`
- Strings: `StringsDSA.java`, `StringsJava.java`
- Recursion: `Recursion.java`, `Recursions.java`
- Two-pointer / Sliding window: `SlidingWindowTwopointer.java`
- Hashing / frequency: `hashing.java`
- Number/digit problems: `Digits.java`
- Classic problems: `TwoSum.java`, `Main.java`, `tempCodeRunnerFile.java`

## Problems (by topic) — one-line descriptions

Arrays
- `ArrayDSA.java` — collection of common array problems and helper utilities (search, traversal, basic transforms).
- `Arraymedium.java` — medium difficulty array problems (subarray sums, rearrangements, typical interview variants).
- `Arrayhard.java` — harder array challenges (more complex invariants, optimized solutions).
- `arsumchat.java` — small utilities and sum/aggregation array exercises.

Binary Search / Searching
- `BinarySearch.java` — binary search implementations and usage examples (lower/upper bound variants).
- `BinarySearchAnswers.java` — worked solutions and edge-case handling for binary-search style problems.

Sorting & Merge
- `SortingAlgo.java` — implementations of classic sorting algorithms and discussion of complexity (merge sort, quicksort, etc.).

Linked Lists
- `LinkedLiastMedium.java` — medium linked-list problems and utilities: reverse (iterative & recursive), detect loop, find loop start, cycle length, palindrome check, delete Nth-from-end, delete middle node, merge-sort on linked list, sort 0s/1s/2s in list, and intersection detection.
- `linkedList.java` — basic singly-linked list operations (insert, delete, traversal).
- `LinkedListIntro.java` — introductory examples and simple manipulations on linked lists.
- `DoublyLL.java` — basic doubly-linked list implementation and operations.
- `DLLmedium.java` — medium-level problems on doubly linked lists.

Strings
- `StringsDSA.java` — common string algorithm problems (palindrome checks, anagrams, substring search patterns).
- `StringsJava.java` — utility methods and Java-specific string handling examples.

Recursion
- `Recursion.java` — foundational recursion problems and examples (factorial, backtracking templates).
- `Recursions.java` — additional recursive exercises including divide-and-conquer examples.

Sliding Window / Two-pointer
- `SlidingWindowTwopointer.java` — sliding-window patterns and two-pointer solutions for subarray/subsequence problems.

Hashing
- `hashing.java` — frequency counting problems, hashing-based lookups, and optimization techniques using hash maps/sets.

Digits / Number problems
- `Digits.java` — digit manipulation problems (reverse digits, sum of digits, digit DP helpers).

Classic / Misc
- `TwoSum.java` — canonical two-sum problem using hashing/two-pointer approaches.
- `Main.java` — sample driver and small demos for running various examples quickly.
- `tempCodeRunnerFile.java` — temporary scratch code used during development.

## How to compile & run

Open a terminal in the project root and run:

```powershell
javac *.java
java <MainClass>
```

Replace `<MainClass>` with a file that contains `public static void main(String[] args)` (for example `LinkedLiastMedium` to run linked-list demos).

### Quick run script (Windows PowerShell)

If you'd like to compile and run a single demo class without compiling the entire repository (useful when other files contain tests or conflicting top-level classes), use the provided `run_class.ps1` script:

```powershell
# compile and run LinkedLiastMedium
.\run_class.ps1 -Class LinkedLiastMedium

# compile and run any other class (must have a main method)
.\run_class.ps1 -Class SomeOtherMainClass
```

The script will compile only the specified `<Class>.java` and then run it. This avoids errors caused by test files or duplicate top-level classes when running `javac *.java`.

## Notes and next steps
- Many files contain example `main` methods; edit or create a small driver to run specific tests you want to verify.
- Consider adding unit tests (JUnit) and small README notes inside subfolders if the repo grows.
- If you want, I can:
	- generate more detailed per-file problem lists by scanning each source file,
	- add a CONTRIBUTING.md with run/tests guidance, or
	- create JUnit tests for a few selected functions (e.g., linked-list palindrome, reverse, intersection).

---

Generated/updated on: 2025-11-22


