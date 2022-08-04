package com.codely.achievement.factories

import com.codely.achievement.AchievementDealer
import com.codely.achievement.LearnerAchievementRepository
import com.codely.achievement.achievements.*

class LearnerAchievementDealerFactory(
    private val learnerAchievements: LearnerAchievementRepository
) : AchievementDealerFactory {
    override fun build(): List<AchievementDealer> {
        return listOf(
            PointsEarned100(learnerAchievements),
            PointsEarned500(learnerAchievements),
            PointsEarned2500(learnerAchievements),
            FrontendGuru(learnerAchievements),
            BackendGuru(learnerAchievements),
            FullStackGuru(learnerAchievements)
        )
    }
}