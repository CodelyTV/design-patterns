Chain of responsibility applied to CommandBus Middlewares
=========================================================

An example of the Chain of responsibility pattern applied
to CommandBus Middlewares.

## Description

In this example we implement a middleware system for a
CommandBus, using the chain of responsibility pattern.

Each element of the chain decorates the execution of the
command:
- LoggerMiddleware: Logs every command dispatched to the command bus
- TransactionalMiddleware: Create a database transaction for each dispatched command
- CommandHandlerMiddleware: Executes the command handler

## Languages

- [Java](java)

## Patterns used in this example

- [Chain of Responsibility](/design-patterns/behavioral/chain-of-responsibility)
