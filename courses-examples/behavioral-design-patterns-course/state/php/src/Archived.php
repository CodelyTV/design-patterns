<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class Archived implements CourseState
{
    /** @throws Exception */
    public function ensureIsAbleToRename(CourseName $newName): void
    {
        throw new Exception('Invalid operation');
    }

    /** @throws Exception */
    public function ensureIsAbleToPublish(Course $course): void
    {
        throw new Exception('Invalid operation');
    }

    /** @throws Exception */
    public function ensureIsAbleToArchive(): void
    {
    }
}
