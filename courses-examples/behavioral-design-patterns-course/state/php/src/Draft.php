<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class Draft implements CourseState
{
    public function ensureIsAbleToRename(CourseName $newName): void
    {
    }

    /** @throws Exception */
    public function ensureIsAbleToPublish(Course $course): void
    {
        if (strlen($course->name()->value()) > 100) {
            throw new Exception('Title too long');
        }
    }

    public function ensureIsAbleToArchive(): void
    {
    }
}
