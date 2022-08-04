package com.codely.achievement.achievements

import com.codely.achievement.*

class FullStackGuru(learnerAchievements: LearnerAchievementRepository) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.frontend >= EarnedPoints(1500) &&
            earnedPoints.backend >= EarnedPoints(1750)
        ) {
            dealAchievement(learnerId, AchievementType.FullStackGuru)
        }
    }
}