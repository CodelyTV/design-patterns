package com.codely.achievement

import java.util.Date

data class LearnerAchievement(
    val id: String,
    val learnerId: String,
    val type: AchievementType,
    val wonOn: Date
)