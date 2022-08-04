<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class Course
{
    public function __construct(
        private readonly CourseId $id,
        private CourseName $name,
        private readonly CourseDuration $duration,
        private CourseStatus $status
    ) {
    }

    public static function draft(
        CourseId $id,
        CourseName $name,
        CourseDuration $duration)
    {
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
        if ($this->status->is(CourseStatus::archived())) {
            throw new Exception('Invalid operation');
        }

        if ($this->status->is(CourseStatus::published())) {
            if (strlen($newName->value()) > 100) {
                throw new Exception('Title too long');
            }
        }

        $this->name = $newName;
    }

    /** @throws Exception */
    public function publish(): void
    {
        if ($this->status->isNot(CourseStatus::draft())) {
            throw new Exception('Invalid operation');
        }

        if (strlen($this->name->value()) > 100) {
            throw new Exception('Title too long');
        }

        $this->status = CourseStatus::published();
    }

    /** @throws Exception */
    public function archive(): void
    {
        if ($this->status->is(CourseStatus::published())) {
            $this->notifyLearners();
        }

        $this->status = CourseStatus::archived();
    }

    private function notifyLearners(): void
    {
        // Not implemented
    }
}
