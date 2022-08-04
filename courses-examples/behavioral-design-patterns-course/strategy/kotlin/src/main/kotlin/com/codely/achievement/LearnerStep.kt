package com.codely.achievement

import java.util.Date

data class LearnerStep(
    val learnerId: String,
    val stepId: String,
    val earnedPoints: EarnedPoints,
    val completedOn: Date
)