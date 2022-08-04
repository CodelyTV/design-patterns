<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class Course
{
    private CourseState $courseState;

    public function __construct(
        private readonly CourseId $id,
        private CourseName $name,
        private readonly CourseDuration $duration,
        private CourseStatus $status
    ) {
        $this->courseState = $this->status->toCourseState();
    }

    public static function draft(
        CourseId $id,
        CourseName $name,
        CourseDuration $duration
    ): Course {
        return new self($id, $name, $duration, CourseStatus::draft());
    }

    public function id(): CourseId
    {
        return $this->id;
    }

    public function name(): CourseName
    {
        return $this->name;
    }

    public function duration(): CourseDuration
    {
        return $this->duration;
    }

    public function status(): CourseStatus
    {
        return $this->status;
    }

    /** @throws Exception */
    public function rename(CourseName $newName): void
    {
        $this->courseState->ensureIsAbleToRename($newName);
        $this->name = $newName;
    }

    /** @throws Exception */
    public function publish(): void
    {
        $this->courseState->ensureIsAbleToPublish($this);
        $this->status = CourseStatus::published();
    }

    /** @throws Exception */
    public function archive(): void
    {
        $this->courseState->ensureIsAbleToArchive();
        $this->status = CourseStatus::archived();
    }
}
