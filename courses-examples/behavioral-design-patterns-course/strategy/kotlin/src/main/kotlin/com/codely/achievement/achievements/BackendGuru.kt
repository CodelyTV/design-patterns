package com.codely.achievement.achievements

import com.codely.achievement.*

class BackendGuru(learnerAchievements: LearnerAchievementRepository) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.backend >= EarnedPoints(2000)) {
            dealAchievement(learnerId, AchievementType.BackendGuru)
        }
    }
}