Strategy pattern applied to an Achievement System
=================================================

An example of the Strategy pattern applied
to Achievement System.

## Description

In this example we start with a LearnerAchievementDealer class,
which is responsible for dealing achievements, when the user
perform some actions in an e-learning platform.

In this example we apply the Strategy design pattern as an
abstraction follow the Open/Close and Single Responsibility
principles: with the Strategy pattern applied, we can add
new achievements without modifying the current behaviour and
classes, and we can alter the dealing strategy depending on some
runtime condition, for example, for doing A/B testing or Dark
Launching.

## Examples

- [Kotlin](kotlin)
- [TypeScript: Functional oriented](achivements-functional)

## Patterns used in this example

- [Strategy](/design-patterns/behavioral/strategy)
- [Abstract Factory](/design-patterns/creational/abstract-factory)
