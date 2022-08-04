package com.codely.achievement.factories

import com.codely.achievement.AchievementDealer

interface AchievementDealerFactory {
    fun build(): List<AchievementDealer>
}