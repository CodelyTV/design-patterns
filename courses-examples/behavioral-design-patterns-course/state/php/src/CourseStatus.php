<?php

declare(strict_types=1);

namespace CodelyTv;

final class CourseStatus extends StringValueObject
{
    private const STATUS_DRAFT = 'draft';
    private const STATUS_PUBLISHED = 'published';
    private const STATUS_ARCHIVED = 'archived';

    private static array $STATUS_STATE_MAP = [
        self::STATUS_DRAFT => Draft::class,
        self::STATUS_PUBLISHED => Published::class,
        self::STATUS_ARCHIVED => Archived::class
    ];

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

    public function toCourseState(): CourseState
    {
        return new self::$STATUS_STATE_MAP[$this->value];
    }
}
