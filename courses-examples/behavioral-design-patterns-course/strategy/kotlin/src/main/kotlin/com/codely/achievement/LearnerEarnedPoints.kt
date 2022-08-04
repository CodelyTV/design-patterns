package com.codely.achievement

data class LearnerEarnedPoints(
    val frontend: EarnedPoints,
    val backend: EarnedPoints
) {
    val total: EarnedPoints = frontend + backend
}
