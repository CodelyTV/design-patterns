<?php

declare(strict_types=1);

namespace CodelyTv\Tests;

use CodelyTv\Course;
use CodelyTv\CourseDuration;
use CodelyTv\CourseId;
use CodelyTv\CourseName;
use CodelyTv\CourseStatus;
use Exception;
use PHPUnit\Framework\TestCase;

final class CourseTest extends TestCase
{
    /**
     * @test
     * @throws Exception
     */
    public function itShouldRenameADraftCourse(): void
    {
        $course = Course::draft(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $course->rename(new CourseName("Hexagonal Architecture"));

        self::assertEquals("Hexagonal Architecture", $course->name());
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToPublishADraftCourseWithALongName(): void
    {
        $tooLongName = "Too long course nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        $course = Course::draft(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName($tooLongName),
            new CourseDuration("3 hours"),
        );

        $this->expectExceptionMessage('Title too long');

        $course->publish();
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldPublishADraftCourse(): void
    {
        $course = Course::draft(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $course->publish();

        self::assertTrue($course->status()->is(CourseStatus::published()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldArchiveADraftCourse(): void
    {
        $course = Course::draft(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $course->archive();

        self::assertTrue($course->status()->is(CourseStatus::archived()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldRenameAPublishedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::published(),
        );

        $course->rename(new CourseName("Hexagonal Architecture"));

        self::assertEquals("Hexagonal Architecture", $course->name());
    }


    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToRenameALongNameForAPublishedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::published(),
        );

        $this->expectExceptionMessage('Title too long');

        $tooLongName = "Too long course nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        $course->rename(new CourseName($tooLongName));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToPublishAPublishedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::published(),
        );

        $this->expectExceptionMessage('Invalid operation');

        $course->publish();
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldArchiveAPublishedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::published(),
        );

        $course->archive();

        self::assertTrue($course->status()->is(CourseStatus::archived()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToRenameAArchivedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::archived(),
        );

        $this->expectExceptionMessage('Invalid operation');

        $course->rename(new CourseName('Clean Architecture'));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToPublishAArchivedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::archived(),
        );

        $this->expectExceptionMessage('Invalid operation');

        $course->publish();
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldArchiveAnArchivedCourse(): void
    {
        $course = new Course(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
            CourseStatus::archived(),
        );

        $course->archive();

        self::assertTrue($course->status()->is(CourseStatus::archived()));
    }
}
