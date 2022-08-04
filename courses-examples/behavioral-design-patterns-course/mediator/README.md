Mediator pattern applied to a Backend use case
==============================================

An example of the Mediator pattern applied
to a Backend use case, to decouple SignUp main
use case from the derived use cases like SendWelcomeEmail.

## Description

In this example we start with a single use case, in which all
the application logic is executed.

In this example we apply the Mediator design pattern as an
abstraction to split the SignUp main use case from the derived
use cases:
- CreateDefaultWorkspace
- AssignUserToWorkspace
- SendWelcomeEmail

## Languages

- [typeScript](typescript)

## Patterns used in this example

- [Mediator](/design-patterns/behavioral/mediator)
