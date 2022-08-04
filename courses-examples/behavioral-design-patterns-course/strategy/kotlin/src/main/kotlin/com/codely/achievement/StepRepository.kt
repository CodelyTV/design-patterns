package com.codely.achievement

interface StepRepository {
    fun find(stepId: String): Step
}