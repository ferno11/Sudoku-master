1. Project Vision

Sudoku Master is a modern, highly polished Sudoku game designed to stand out on the Google Play Store through:

Rock-solid core Sudoku mechanics

Modular, theme-agnostic game logic

Multiple difficulty levels and modes derived from a single core engine

Future-proof architecture for visuals, audio, analytics, and monetization

Clean, player-friendly UX focused on clarity, flow, and satisfaction

Core Principle

Game logic must NEVER depend on UI, theme, or visuals.
Visuals, themes, and effects plug into the engine — not the other way around.

This rule is absolute and non-negotiable.

2. Development Philosophy (LLM Instructions)

Any AI or developer contributing to this project must strictly follow these rules.

2.1 Separation of Concerns

Core Sudoku Engine → Pure logic only

UI / Themes → Presentation only

State Management → Isolated, immutable, and testable

No cross-layer shortcuts are allowed.

2.2 Deterministic Logic

Given the same seed, the same puzzle must always be generated

Difficulty must be measurable and explainable, never subjective

2.3 Extensibility First

New modes must be added via configuration, not rewrites

New themes must never affect gameplay logic

Features should be additive, not invasive

2.4 Play Store Readiness

Performance optimized

Offline-first

Minimal permissions

Battery-conscious

Accessibility-aware

3. High-Level Roadmap
Phase 1 – Core Game Design (FOUNDATION)

🚨 Highest priority. Everything depends on this phase.

Sudoku board representation

Puzzle generation

Puzzle validation

Difficulty system

Game state handling (undo, redo, notes)

Mode extensibility

Phase 2 – UX & Interaction Layer

Input handling

Animations (non-blocking)

Error highlighting

Accessibility features

Phase 3 – Visual Themes & Audio

Light / Dark / Custom themes

Sound effects & haptics

Skin-based UI system

Phase 4 – Meta Systems

Progression

Achievements

Daily puzzles

Hint economy

Phase 5 – Monetization & Release

Ads & Premium

Analytics

Store assets

Play Store compliance

4. Core Sudoku Game Design (ENGINE FIRST)
4.1 Board Representation

Standard 9×9 grid

Divided into 9 sub-grids (3×3)

Each cell contains:

value: Int? (1–9 or null)
isFixed: Boolean
notes: Set<Int>


Board structure:

Board
- cells[9][9]
- solution[9][9]

4.2 Core Rules Engine

Must enforce:

Row uniqueness (1–9)

Column uniqueness (1–9)

Sub-grid uniqueness (1–9)

Validation levels:

Cell-level

Row / Column / Sub-grid

Full-board (win condition)

4.3 Puzzle Generator (CRITICAL)
Requirements

Every puzzle must have exactly one solution

Difficulty must be derived from:

Number of clues

Required solving techniques

Solver backtracking depth

Architecture

Generate a fully solved board

Remove numbers strategically

Validate uniqueness after each removal

Score difficulty

Store puzzle + solution

4.4 Difficulty System (Config-Based)

Difficulty is never hardcoded.

DifficultyProfile
- minClues
- maxClues
- allowedTechniques
- maxBacktrackingDepth
- mistakeTolerance


Initial difficulties:

Easy

Medium

Hard

Expert

Master (optional)

Adding a new difficulty = adding a new profile.

4.5 Core Game Mechanics

Supported actions:

Number input

Erase

Notes (manual & auto)

Undo / Redo

Hint (logic-based)

Pause / Resume

Game state:

GameState
- board
- moveHistory
- elapsedTime
- mistakes
- difficulty
- mode

5. Game Modes (Engine Wrappers)

Modes are wrappers around the same engine, never separate engines.

Planned Modes

Classic – Traditional Sudoku

Timed – Countdown or stopwatch

Relaxed – No mistakes, unlimited hints

Challenge – Limited resources, scoring

Daily Puzzle – Seed-based, same for all players

All modes differ only in:

Configuration values

Rule toggles

Scoring logic

6. Theme & Visual Integration Strategy
Rule

Themes NEVER touch Sudoku logic.

Themes control:

Colors

Fonts

Cell styles

Animations

Sound mappings

Themes can be:

Swapped at runtime

Downloaded later

Premium locked

7. Data & Persistence

Stored locally:

Ongoing games

User preferences

Statistics

Completed puzzles

Puzzle format:

Puzzle
- id
- seed
- difficulty
- initialBoard
- solution

8. Testing Strategy (MANDATORY)

Before UI polish:

Unit tests for:

Solver

Generator

Validator

Edge cases:

Nearly complete boards

Invalid inputs

Undo/redo stress tests

9. Monetization & Revenue System (Planned)
Principles

Never block gameplay

No pay-to-win

Ads must be optional and non-intrusive

Models

Ads

Banner (optional, bottom only)

Interstitial (post-completion only)

Rewarded (hints, undo restore, time extension)

Premium

Ad-free

Unlimited hints

Advanced themes

Detailed stats

Exclusive modes (optional)

Architecture
MonetizationService
- isPremium()
- showInterstitial()
- showRewardedAd(onReward)
- isAdAvailable()


Game logic only requests monetization actions.

10. Analytics & Privacy

Tracked anonymously:

Completion rate

Time per difficulty

Hint usage

Drop-off points

Mode popularity

Rules:

No personal data

GDPR-compliant

Opt-out supported

11. Play Store Deployment

Offline-first

Latest Android SDK

Adaptive icons

Tablet & foldable support

64-bit only

Cold start < 2s

Release pipeline:
Development → Internal → Closed → Open Beta → Production

12. FINALIZED TECH STACK (MANDATORY)
Development Environment

Android Studio (required)

Kotlin-first project

Gradle Kotlin DSL (KTS)

Core Stack

Language: Kotlin

UI: Jetpack Compose

Architecture: MVVM + Clean Architecture

State: ViewModel + immutable state

Persistence: Room + DataStore

Ads: Google AdMob

Billing: Play Billing Library

Analytics: Firebase Analytics

Testing: JUnit, Compose UI tests

🚨 No alternative frameworks or stacks may be introduced without explicit approval.

13. Accessibility Requirements

Color-blind safe palettes

High-contrast mode

Scalable text & grid

Haptic & sound toggles

One-hand mode (optional)

Screen reader support (TalkBack)

Accessibility must be designed-in, not added later.

14. Performance Constraints

No allocations in render loops

Solver runs off main thread

Animations capped at 60fps

Minimal wake locks

Zero background work when idle

15. Difficulty Fairness Rules

Every puzzle solvable by logic alone

No guessing required

Difficulty based on techniques, not clue count

Hints explain why, not just what

16. Hint System Design

Step-based hints

No solution dumping

Escalation:

Nudge

Technique explanation

Cell suggestion

Reveal (last resort)

17. Player-Friendly UX Rules

No accidental overwrites

Confirmation for destructive actions

Unlimited undo (configurable)

Informative mistakes

Never shame the player

18. Localization Strategy

All strings externalized

RTL support

Locale-aware fonts

No text baked into images

19. Versioning & Migration

Versioned puzzle data

Backward-compatible saves

Graceful schema migration

Recovery for corrupted data

20. Feature Flags

Enable/disable modes remotely

Control ad frequency

Test new difficulties

Roll back features without updates

21. Feedback Channels

In-app feedback

Non-intrusive rating prompts

Crash feedback opt-in

Beta tester channel

22. Non-Goals (Explicit)

This app will never:

Force ads

Be pay-to-win

Sell user data

Use dark UX patterns

Fake difficulty

23. AI CODING BEST PRACTICES (MANDATORY)

Any AI-generated code must:

Follow Clean Architecture boundaries

Use immutable data where possible

Prefer composition over inheritance

Avoid premature optimization

Be readable over clever

Include clear naming

Be testable

Avoid side effects in core logic

Never mix UI with engine logic

If unsure → ask before coding.

✅ FINAL NOTE

This README is the single source of truth for the project.
If any future decision conflicts with this document, this document wins unless explicitly updated.