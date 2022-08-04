<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class ArchiveCourse extends Course
{
    public function __construct(
        CourseId       $id,
        CourseName     $name,
        CourseDuration $duration
    )
    {
        parent::__construct($id, $name, $duration);
        $this->status = CourseStatus::archived();
    }

    /** @throws Exception */
    public function publish(): PublishedCourse
    {
        throw new Exception('Invalid operation');
    }

    public function archive(): ArchiveCourse
    {
        return $this;
    }

    protected function ensureCanRename(CourseName $newName): void
    {
        throw new Exception('Invalid operation');
    }
}
