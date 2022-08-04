package com.codely.achievement

import com.codely.achievement.factories.LearnerAchievementDealerFactory

fun main(args: Array<String>) {

    val earnedPoints = LearnerEarnedPoints(
        EarnedPoints(3500),
        EarnedPoints(1500)
    )
    val learnerId = "learnerId"
    val learner = Learner(learnerId, earnedPoints)

    val learnerAchievements = InMemoryLearnerAchievementRepository()
    val dealersFactory = LearnerAchievementDealerFactory(learnerAchievements)
    val learnerAchievementDealer = LearnerAchievementDealer(learnerAchievements, dealersFactory)

    val stepCompleter = StepCompleter(
        ConstantLearnerRepository(learner),
        DummyStepRepository(),
        VoidLearnerStepsRepository(),
        learnerAchievementDealer
    )

    stepCompleter.completeStep("stepId", learnerId)
}
