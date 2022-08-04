<?php

declare(strict_types=1);

namespace CodelyTv;

final class CourseStatus extends StringValueObject
{
    private const STATUS_DRAFT = 'draft';
    private const STATUS_PUBLISHED = 'published';
    private const STATUS_ARCHIVED = 'archived';

    public static function draft(): CourseStatus
    {
        return new CourseStatus(self::STATUS_DRAFT);
    }

    public static function published(): CourseStatus
    {
        return new CourseStatus(self::STATUS_PUBLISHED);
    }

    public static function archived(): CourseStatus
    {
        return new CourseStatus(self::STATUS_ARCHIVED);
    }

    public function is(CourseStatus $courseStatus): bool
    {
        return $this->value === $courseStatus->value;
    }

    public function isNot(CourseStatus $courseStatus): bool
    {
        return $this->value !== $courseStatus->value;
    }
}
