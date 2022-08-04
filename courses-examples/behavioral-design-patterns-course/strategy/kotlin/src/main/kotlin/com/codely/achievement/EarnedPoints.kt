package com.codely.achievement

data class EarnedPoints(val value: Int) {
    operator fun compareTo(other: EarnedPoints): Int {
        if (value == other.value) {
            return 0
        }

        return if (value > other.value) 1 else -1
    }

    operator fun plus(other: EarnedPoints): EarnedPoints {
        return EarnedPoints(value + other.value)
    }
}