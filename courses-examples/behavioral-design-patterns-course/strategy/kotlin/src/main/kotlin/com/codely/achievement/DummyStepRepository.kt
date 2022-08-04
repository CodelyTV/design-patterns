package com.codely.achievement

class DummyStepRepository : StepRepository {
    override fun find(stepId: String): Step {
        return Step(stepId, 100)
    }
}