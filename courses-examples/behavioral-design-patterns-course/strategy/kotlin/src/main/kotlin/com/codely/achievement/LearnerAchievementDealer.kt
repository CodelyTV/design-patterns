package com.codely.achievement

import com.codely.achievement.factories.AchievementDealerFactory

class LearnerAchievementDealer (
    learnerAchievements: LearnerAchievementRepository,
    private val dealersFactory: AchievementDealerFactory
) : AchievementDealer(learnerAchievements) {
    override fun dealAchievements(learnerId: String, earnedPoints: LearnerEarnedPoints) {
        dealersFactory
            .build()
            .forEach { dealer -> dealer.dealAchievements(learnerId, earnedPoints) }
    }
}