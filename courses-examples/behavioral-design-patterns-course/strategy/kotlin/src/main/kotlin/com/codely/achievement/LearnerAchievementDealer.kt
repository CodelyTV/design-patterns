package com.codely.achievement

import java.util.*

class LearnerAchievementDealer(
    private val learnerAchievements: LearnerAchievementRepository
) {
    fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.total >= EarnedPoints(100)) {
            dealAchievement(learnerId, AchievementType.PointsEarned100)
        }
        if (earnedPoints.total >= EarnedPoints(500)) {
            dealAchievement(learnerId, AchievementType.PointsEarned500)
        }
        if (earnedPoints.total >= EarnedPoints(2500)) {
            dealAchievement(learnerId, AchievementType.PointsEarned2500)
        }

        if (earnedPoints.frontend >= EarnedPoints(2000)) {
            dealAchievement(learnerId, AchievementType.FrontendGuru)
        }
        if (earnedPoints.backend >= EarnedPoints(3000)) {
            dealAchievement(learnerId, AchievementType.BackendGuru)
        }
        if (earnedPoints.frontend >= EarnedPoints(1500) &&
            earnedPoints.backend >= EarnedPoints(1750)
        ) {
            dealAchievement(learnerId, AchievementType.FullStackGuru)
        }
    }

    private fun dealAchievement(learnerId: String, type: AchievementType) {
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