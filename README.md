# University OOP Lab — Inheritance, Aggregation, Polymorphism, Overloading (+Bonus)

This lab demonstrates the core pillars of OOP in Java using a small “University” domain:

- **Abstraction & Inheritance**: `CommunityMember` (abstract) → `Student`, `Professor`, `Staff`
- **Aggregation (HAS‑A)**: `Course` *has a* `Professor` instructor and a list of enrolled `Student`s
- **Polymorphism**: a single `List<CommunityMember>` that holds different subclasses and calls overridden methods
- **Method Overloading**: two `enrollStudent` methods in `Course`
- **Bonus (Instance Initializer Block)**: assigns a unique `memberNo` to every `CommunityMember` instance

---

## Files
- `UniversityLab.java` — all classes + `main`

> Your code already meets the rubric. Add the **bonus** snippet (below) and print the value to demonstrate it.

---

## How to run

```bash
# Compile
javac UniversityLab.java

# Run
java UniversityLab
```

> Requires **Java 11+** (because of `List.of(...)`). If you are on Java 8, replace `new ArrayList<>(List.of(...))` with `new ArrayList<>(java.util.Arrays.asList(...))`.

---

## Where each rubric item is implemented

### 1) Inheritance Hierarchy (25%)
- `CommunityMember` is **abstract** and declares abstract `getRole()`
- Subclasses `Student`, `Professor`, `Staff` **extend** it and **override** `getRole()` and `toString()`
- Subclass constructors call `super(id, name)`

### 2) Aggregation (HAS‑A) (20%)
- Class `Course` contains:
  - `Professor instructor`
  - `List<Student> enrolledStudents`
- Students are added to the course via `enrollStudent(...)`

### 3) Polymorphism / Overriding (25%)
- `List<CommunityMember> members = new ArrayList<>(List.of(...))`
- Looping that list calls `.toString()` and `.getRole()` on different concrete types

### 4) Method Overloading (10%)
- `enrollStudent(Student s)`
- `enrollStudent(List<Student> students)` (or `ArrayList<Student>` in your original code)
- Both are demonstrated in `main`

### 5) Code Quality & README (20%)
- This README explains how to compile/run and maps code → rubric
- Keep names consistent (`department`, `instructor`) and prefer `List<Student>` for fields

### 6) **Bonus (+5%) — Instance Initializer Block**
Add the following to `CommunityMember` **exactly as shown**, then demonstrate it in `main`.

```java
abstract class CommunityMember {
    private static int seq = 1;      // shared counter across all community members
    private final int memberNo;      // auto-assigned by the instance initializer

    { // INSTANCE INITIALIZER BLOCK (runs before the constructor body for each instance)
        memberNo = seq++;
    }

    // existing fields
    private int id;
    private String name;

    public CommunityMember(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getMemberNo() { return memberNo; }

    // ... rest of your class (getters/setters/toString/getRole)
}
```

**Demonstrate it** — in your polymorphic loop in `main`, add one line:
```java
System.out.println("Member No: " + mem.getMemberNo());
```
You should see incrementing `Member No` values across all created members (Professor, Student, Staff).

---

## Sample (truncated) output

```
id: 10001
name: Steftcho P.Dokov
Department: Computer Science
Role: Professor
Member No: 1

id: 2410201
name: Behruz
GPA: 4.12
Role: Student
Member No: 2
...
```

---

## Notes / Suggestions
- Prefer `private final List<Student> enrolledStudents = new ArrayList<>();`
- For readability, fix typos: `department`, `instructor`, “Data Structures and Algorithms”
- Optionally add a varargs overload:
  ```java
  public void enrollStudent(Student... students) {
      enrolledStudents.addAll(java.util.Arrays.asList(students));
  }
  ```

Happy coding!
