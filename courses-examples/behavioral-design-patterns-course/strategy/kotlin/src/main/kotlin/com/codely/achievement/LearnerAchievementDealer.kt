package com.codely.achievement

import com.codely.achievement.achievements.*

class LearnerAchievementDealer (
    private val learnerAchievements: LearnerAchievementRepository
) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        PointsEarned100(learnerAchievements).dealAchievements(learnerId, earnedPoints)
        PointsEarned500(learnerAchievements).dealAchievements(learnerId, earnedPoints)
        PointsEarned2500(learnerAchievements).dealAchievements(learnerId, earnedPoints)
        FrontendGuru(learnerAchievements).dealAchievements(learnerId, earnedPoints)
        BackendGuru(learnerAchievements).dealAchievements(learnerId, earnedPoints)
        FullStackGuru(learnerAchievements).dealAchievements(learnerId, earnedPoints)
    }
}