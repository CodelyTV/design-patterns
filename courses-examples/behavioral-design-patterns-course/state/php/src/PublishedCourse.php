<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class PublishedCourse extends Course
{
    public function __construct(
        CourseId $id,
        CourseName $name,
        CourseDuration $duration
    ) {
        parent::__construct($id, $name, $duration);
        $this->status = CourseStatus::published();
    }

    /** @throws Exception */
    public function publish(): PublishedCourse
    {
        throw new Exception('Invalid operation');
    }

    /** @throws Exception */
    public function archive(): ArchiveCourse
    {
        $this->notifyLearners();

        return new ArchiveCourse(
            $this->id,
            $this->name,
            $this->duration
        );
    }

    protected function ensureCanRename(CourseName $newName): void
    {
        if (strlen($newName->value()) > 100) {
            throw new Exception('Title too long');
        }
    }

    private function notifyLearners(): void
    {
        // Not implemented
    }
}
