
# RULES.md — Mandatory Development Rules

These rules are absolute.  
Violating them is considered a defect.

---

## 1. Architecture Rules

- `core/` must contain **zero Android imports**
- UI layer must not contain Sudoku rules
- Domain layer coordinates logic, not implements it
- Services (ads, analytics) must not affect game outcomes

---

## 2. Code Quality Rules

- Kotlin only
- Immutable data structures where possible
- Clear, descriptive naming
- Small functions with single responsibility
- No magic numbers (use constants or config)
- No commented-out code

---

## 3. Game Logic Rules

- Every puzzle must have exactly one solution
- Difficulty must be configuration-driven
- Solver must run off the main thread
- Hints must be logic-based, not brute force
- No guessing required to solve puzzles

---

## 4. UI Rules

- Jetpack Compose only
- Stateless composables where possible
- UI observes state, never mutates it
- Animations must be non-blocking

---

## 5. Performance Rules

- No allocations in render loops
- No blocking calls on main thread
- Cold start under 2 seconds target
- Background work only when necessary

---

## 6. Dependency Rules

- Use Gradle Version Catalog
- No experimental libraries
- No reflection-heavy frameworks
- No game engines

---

## 7. AI Behavior Rules

- If instructions are ambiguous → ask first
- If something violates README → stop
- If unsure of best approach → propose options
- Never silently change architecture

---

## 8. Final Authority

Priority order for conflicts:

1. README.md
2. RULES.md
3. AGENT.md
4. Task instructions

If in doubt, stop and ask.
