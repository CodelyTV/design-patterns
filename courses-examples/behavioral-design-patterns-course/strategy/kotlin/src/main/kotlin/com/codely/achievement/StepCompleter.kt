package com.codely.achievement

import java.util.Date

class StepCompleter(
    private val learners: LearnerRepository,
    private val steps: StepRepository,
    private val learnerSteps: LearnerStepRepository,
    private val learnerAchievementDealer: LearnerAchievementDealer
    ) {

    fun completeStep(stepId: String, learnerId: String) {
        val step = steps.find(stepId)
        val learner = learners.find(learnerId)

        val learnerStep = LearnerStep(
            stepId,
            learnerId,
            EarnedPoints(step.totalPoints),
            Date())
        learnerSteps.save(learnerStep)

        learnerAchievementDealer.dealAchievements(learnerId, learner.earnedPoints)
    }
}