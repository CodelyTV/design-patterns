Command pattern applied to HTTP Controllers
===========================================

An example of the Command pattern applied
to HTTP Controllers, to decouple the application
logic from the HTTP request handling.

## Description

In this example we start with a coupled controller, in which all
the application logic is executed.

Following Single Responsibility Principle, we want to
refactor the controller, by moving the application logic to
another class (the use case class), keeping only the responsibility
of the request handling.

In this example we apply the Command design pattern as an
abstraction to communicate the Controllers with the
corresponding use case.

## Steps

To navigate between steps use `git checkout` command
using the specified commit hash below 👇

1. Starting point (hash)
2. Apply command pattern (hash)

## Languages

- [Java](java)

## Patterns used in this example

- [Command](/design-patterns/behavioral/command)
- [Template Method](/design-patterns/behavioral/template-method)
