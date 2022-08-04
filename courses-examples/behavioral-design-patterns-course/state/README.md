State pattern applied to a Course domain model
==============================================

An example of the State pattern applied
to the Domain model.

## Description

In this example we start a Course domain model. We can
perform the following operations to the Course:
- publish
- archive
- rename

Depending of the status of the Course (draft, published or archive)
we are not allowed to perform some operations. For example, we
can't publish an already published course. Also, the rename operation
have the following restrictions:

- The is no limitation in the length of the name of a draft course.
- A published course name length must be less than or equal to 100 characters

In this example we apply the State design pattern in two ways:
1. Without modifying the clients using the Course.
2. Modifying our clients.

## Languages

- [PHP](php)

## Patterns used in this example

- [State](/design-patterns/behavioral/state)
