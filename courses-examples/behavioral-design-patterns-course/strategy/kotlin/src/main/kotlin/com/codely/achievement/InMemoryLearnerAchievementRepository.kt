package com.codely.achievement

class InMemoryLearnerAchievementRepository : LearnerAchievementRepository {

    private val achievements: MutableList<LearnerAchievement> = mutableListOf()

    override fun save(learnerAchievement: LearnerAchievement) {
        achievements.add(learnerAchievement)
    }

    fun has(learnerId: String, achievementType: AchievementType): Boolean {
        val achievement = achievements.find { achievement -> achievement.learnerId == learnerId && achievement.type == achievementType }
        return achievement != null
    }
}