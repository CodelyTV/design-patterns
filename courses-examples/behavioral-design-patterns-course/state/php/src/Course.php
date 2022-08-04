<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

abstract class Course
{
    protected CourseStatus $status;

    public function __construct(
        protected readonly CourseId $id,
        protected CourseName $name,
        protected readonly CourseDuration $duration,
    ) {
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
        $this->ensureCanRename($newName);
        $this->name = $newName;
    }

    /** @throws Exception */
    abstract protected function ensureCanRename(CourseName $newName): void;

    /** @throws Exception */
    abstract public function publish(): PublishedCourse;

    /** @throws Exception */
    abstract public function archive(): ArchiveCourse;
}
