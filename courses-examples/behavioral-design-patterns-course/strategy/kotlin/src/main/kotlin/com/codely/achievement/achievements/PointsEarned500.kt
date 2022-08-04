package com.codely.achievement.achievements

import com.codely.achievement.*

class PointsEarned500(learnerAchievements: LearnerAchievementRepository) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        if (earnedPoints.total >= EarnedPoints(500)) {
            dealAchievement(learnerId, AchievementType.PointsEarned500)
        }
    }
}