<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class DraftCourse extends Course
{
    public function __construct(
        CourseId       $id,
        CourseName     $name,
        CourseDuration $duration,
    ) {
        parent::__construct($id, $name, $duration);
        $this->status = CourseStatus::draft();
    }

    /** @throws Exception */
    public function publish(): PublishedCourse
    {
        $this->ensureTitleValidLength();
        return new PublishedCourse(
            $this->id,
            $this->name,
            $this->duration
        );
    }

    /** @throws Exception */
    public function archive(): ArchiveCourse
    {
        return new ArchiveCourse(
            $this->id,
            $this->name,
            $this->duration
        );
    }

    protected function ensureCanRename(CourseName $newName): void
    {
    }

    /**
     * @throws Exception
     */
    private function ensureTitleValidLength(): void
    {
        if (strlen($this->name->value()) > 100) {
            throw new Exception('Title too long');
        }
    }
}
