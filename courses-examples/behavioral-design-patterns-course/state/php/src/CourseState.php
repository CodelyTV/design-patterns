<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

interface CourseState
{
    /** @throws Exception */
    public function ensureIsAbleToRename(CourseName $newName): void;

    /** @throws Exception */
    public function ensureIsAbleToPublish(Course $course): void;

    /** @throws Exception */
    public function ensureIsAbleToArchive(): void;
}
