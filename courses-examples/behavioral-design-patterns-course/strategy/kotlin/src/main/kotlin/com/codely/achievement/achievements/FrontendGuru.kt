package com.codely.achievement.achievements

import com.codely.achievement.*

class FrontendGuru(learnerAchievements: LearnerAchievementRepository) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.frontend >= EarnedPoints(2000)) {
            dealAchievement(learnerId, AchievementType.FrontendGuru)
        }
    }
}