<?php

declare(strict_types=1);

namespace CodelyTv\Tests;

use CodelyTv\ArchiveCourse;
use CodelyTv\Course;
use CodelyTv\CourseDuration;
use CodelyTv\CourseId;
use CodelyTv\CourseName;
use CodelyTv\CourseStatus;
use CodelyTv\DraftCourse;
use CodelyTv\PublishedCourse;
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
        $course = new DraftCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $course->rename(new CourseName("Hexagonal Architecture"));

        self::assertEquals("Hexagonal Architecture", $course->name()->value());
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToPublishADraftCourseWithALongName(): void
    {
        $tooLongName = "Too long course nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        $course = new DraftCourse(
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
        $course = new DraftCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $publishedCourse = $course->publish();

        self::assertTrue($publishedCourse->status()->is(CourseStatus::published()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldArchiveADraftCourse(): void
    {
        $course = new DraftCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $archivedCourse = $course->archive();

        self::assertTrue($archivedCourse->status()->is(CourseStatus::archived()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldRenameAPublishedCourse(): void
    {
        $course = new PublishedCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours")
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
        $course = new PublishedCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
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
        $course = new PublishedCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
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
        $course = new PublishedCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $archivedCourse = $course->archive();

        self::assertTrue($archivedCourse->status()->is(CourseStatus::archived()));
    }

    /**
     * @test
     * @throws Exception
     */
    public function itShouldThrowAnErrorWhenTryingToRenameAArchivedCourse(): void
    {
        $course = new ArchiveCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
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
        $course = new ArchiveCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
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
        $course = new ArchiveCourse(
            new CourseId("26f8d989-4e27-48e2-a346-14b8611de15f"),
            new CourseName("Arquitectura Hexagonal"),
            new CourseDuration("3 hours"),
        );

        $archivedCourse = $course->archive();

        self::assertTrue($archivedCourse->status()->is(CourseStatus::archived()));
    }
}
