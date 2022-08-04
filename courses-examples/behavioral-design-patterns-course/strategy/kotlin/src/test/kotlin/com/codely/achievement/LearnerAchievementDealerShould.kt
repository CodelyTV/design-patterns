package com.codely.achievement

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LearnerAchievementDealerShould {
    private val userAchievements = InMemoryLearnerAchievementRepository()
    private val learnerAchievementDealer = LearnerAchievementDealer(userAchievements)

    @Test
    fun `deal 100 points achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(100),
            EarnedPoints(0)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.PointsEarned100))
    }

    @Test
    fun `deal 500 points achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(500),
            EarnedPoints(0)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.PointsEarned500))
    }

    @Test
    fun `deal 2500 points achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(2500),
            EarnedPoints(0)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.PointsEarned2500))
    }

    @Test
    fun `deal front-end guru achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(2000),
            EarnedPoints(0)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.FrontendGuru))
    }

    @Test
    fun `deal backend-end guru achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(0),
            EarnedPoints(3000)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.BackendGuru))
    }

    @Test
    fun `deal fullstack guru achievement`() {
        val learnerId = "learnerId"
        val earnedPoints = LearnerEarnedPoints(
            EarnedPoints(1500),
            EarnedPoints(1750)
        )

        learnerAchievementDealer.dealAchievements(learnerId, earnedPoints)

        assertTrue(userAchievements.has(learnerId, AchievementType.FullStackGuru))
    }
}
