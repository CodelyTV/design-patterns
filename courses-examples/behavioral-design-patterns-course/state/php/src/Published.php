<?php

declare(strict_types=1);

namespace CodelyTv;

use Exception;

final class Published implements CourseState
{
    /** @throws Exception */
    public function ensureIsAbleToRename(CourseName $newName): void
    {
        if (strlen($newName->value()) > 100) {
            throw new Exception('Title too long');
        }
    }

    /** @throws Exception */
    public function ensureIsAbleToPublish(Course $course): void
    {
        throw new Exception('Invalid operation');
    }

    /** @throws Exception */
    public function ensureIsAbleToArchive(): void
    {
        $this->notifyLearners();
    }

    private function notifyLearners(): void
    {
        // Not implemented
    }
}
