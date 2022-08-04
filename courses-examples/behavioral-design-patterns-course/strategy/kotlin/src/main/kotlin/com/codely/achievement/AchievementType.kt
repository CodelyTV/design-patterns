package com.codely.achievement

enum class AchievementType {
    PointsEarned100 {
        override fun description() = "100 Points earned"
    },
    PointsEarned500 {
        override fun description() = "500 Points earned"
    },
    PointsEarned2500 {
        override fun description() = "2500 Points earned"
    },
    FrontendGuru {
        override fun description() = "Front-end guru"
    },
    BackendGuru {
        override fun description() = "Back-end guru"
    },
    FullStackGuru {
        override fun description() = "FullStack guru"
    };

    abstract fun description(): String
}