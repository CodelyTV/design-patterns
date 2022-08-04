package com.codely.achievement

import java.util.*

abstract class AchievementDealer(private val learnerAchievements: LearnerAchievementRepository) {
    abstract fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints)

    protected fun dealAchievement(learnerId: String, type: AchievementType) {
        val achievement = LearnerAchievement(
            "id",
            learnerId,
            type,
            Date()
        )
        learnerAchievements.save(achievement)
        println(type.description())
    }
}