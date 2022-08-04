package com.codely.achievement.achievements

import com.codely.achievement.*

class PointsEarned100(learnerAchievements: LearnerAchievementRepository) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.total >= EarnedPoints(100)) {
            dealAchievement(learnerId, AchievementType.PointsEarned100)
        }
    }
}