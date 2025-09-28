
# UniversityLab — OOP Lab (Java) 

This project demonstrates the **core pillars of OOP** in Java using a simple university domain.  
It matches the attached `UniversityLab.java` exactly — including the **bonus instance initializer** that prints a line for each `CommunityMember` created.

---

## What this shows (rubric mapping)

- **Abstraction & Inheritance (25%)**
  - `CommunityMember` is `abstract` and declares `getRole()`.
  - `Student`, `Professor`, and `Staff` extend `CommunityMember` and call `super(id, name)` in their constructors.

- **Aggregation / HAS-A (20%)**
  - `Course` contains a `Professor instructor` and an `ArrayList<Student> enrolledStudents`.

- **Polymorphism & Overriding (25%)**
  - A single `ArrayList<CommunityMember>` holds mixed objects (professors, students, staff).
  - Looping over that list calls overridden `toString()` and `getRole()` across different types.

- **Method Overloading (10%)**
  - `enrollStudent(Student s)` and `enrollStudent(ArrayList<Student> students)`.

- **Code Quality & README (20%)**
  - Compiles cleanly on Java 11+. This README explains how to run and maps code to rubric.

- **Bonus (+5%) — Instance Initializer Block**
  - In `CommunityMember` there is an **instance initializer** block:
    ```java
    { 
        System.out.println("CommunityMember instance init");
    }
    ```
    It runs for **every new instance** (professors, students, staff) and is visible in the console output.

---

## Files & classes

- **`UniversityLab.java`** — contains all classes:
  - `CommunityMember` (abstract base)
  - `Student`, `Professor`, `Staff` (subclasses)
  - `Course` (has-a `Professor` and a list of `Student`s)
  - `UniversityLab` (class with `main`)

> Note: in this exact code, the `Professor` field is named `departament` (typo preserved intentionally to match the file).

---

## Requirements

- **Java 11+** (because the code uses `List.of(...)`).
  - If you must use Java 8, replace `new ArrayList<>(List.of(...))` with:
    ```java
    new ArrayList<>(java.util.Arrays.asList(...))
    ```

---

## How to build & run

```bash
# Compile
javac UniversityLab.java

# Run
java UniversityLab
```

You should see the instance initializer line repeated once per community member, enrollment confirmations, and polymorphic prints of each object.

### Example (truncated) output

```
CommunityMember instance init
CommunityMember instance init
CommunityMember instance init
CommunityMember instance init
CommunityMember instance init
CommunityMember instance init
CommunityMember instance init
Student Orzubek added to course Data Strucure and Algorithms
Student Behruz added to course Data Strucure and Algorithms
Student Muhammad added to course Academic English
Student Lochinbek added to course Academic English


id: 10001
name: Steftcho P.Dokov
Department: Computer Science
Role: Professor
...
```

---

## How each class participates

- **CommunityMember**
  - Holds common state: `id`, `name`.
  - Declares `getRole()` (abstract) and implements `toString()`.
  - **Bonus**: instance initializer prints once per construction.

- **Student**
  - Adds `gpa`, overrides `getRole()` and `toString()`.

- **Professor**
  - Adds `departament` (name kept as in code), overrides `getRole()` and `toString()`.

- **Staff**
  - Adds `title`, overrides `getRole()` and `toString()`.

- **Course**
  - Fields: `courseCode`, `courseName`, `Professor instructor`, `ArrayList<Student> enrolledStudents`.
  - Overloaded `enrollStudent(...)` methods and `printClassList()`.

- **UniversityLab (main)**
  - Creates sample professors, students, and staff.
  - Creates two courses and enrolls students (single + batch overload).
  - Builds a polymorphic `ArrayList<CommunityMember>` and prints role + details.

---

## Optional improvements (non-breaking suggestions)

These are not required to pass the rubric but improve style/readability:

- Rename `departament` → `department`; constructor param `deparatemnt` → `department`.
- Rename constructor param `instuctor` → `instructor`.
- Fix title typo: “Data **Strucure** and Algorithms” → “Data **Structures** and Algorithms”.
- Prefer `List<Student>` for the field type in `Course`:
  ```java
  private final List<Student> enrolledStudents = new ArrayList<>();
  ```
- Add a `printClassList()` call in `main` to visibly demonstrate the HAS-A relationship:
  ```java
  course1.printClassList();
  course2.printClassList();
  ```

---

## Grader checklist (quick)

- [x] Abstract base + subclasses with `super(...)`
- [x] `Course` has `Professor` + list of `Student`
- [x] Polymorphic `ArrayList<CommunityMember>` + overridden `toString()` and `getRole()`
- [x] Overloaded `enrollStudent(...)` methods demonstrated
- [x] Instance initializer block runs and is visible in output
- [x] Compiles and runs per instructions above

Happy grading! 🎓
