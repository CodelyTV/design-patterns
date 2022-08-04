package com.codely.achievement

interface LearnerRepository {
    fun find(learnerId: String): Learner
}
