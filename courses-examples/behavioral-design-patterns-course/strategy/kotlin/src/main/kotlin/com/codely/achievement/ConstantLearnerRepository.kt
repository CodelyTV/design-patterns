package com.codely.achievement

class ConstantLearnerRepository(private val learner: Learner) : LearnerRepository {
    override fun find(learnerId: String): Learner {
        return learner
    }
}