package com.codely.achievement

fun main(args: Array<String>) {

    val earnedPoints = LearnerEarnedPoints(
        EarnedPoints(3500),
        EarnedPoints(1500)
    )
    val learnerId = "learnerId"
    val learner = Learner(learnerId, earnedPoints)

    val learnerAchievementDealer = LearnerAchievementDealer(InMemoryLearnerAchievementRepository())

    val stepCompleter = StepCompleter(
        ConstantLearnerRepository(learner),
        DummyStepRepository(),
        VoidLearnerStepsRepository(),
        learnerAchievementDealer
    )

    stepCompleter.completeStep("stepId", learnerId)
}
