package com.yoon.portfolio.admin.context.achievement.form

import com.yoon.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(

    @field:NotBlank(message = "필수값입니다.")
    val title: String,

    @field:NotBlank(message = "필수값입니다.")
    val description: String,

    @field:NotBlank(message = "필수값입니다.")
    val host: String,

    @field:NotBlank(message = "필수값입니다.")
    val achievedDate: String,

    val isActive: Boolean,

){
    // 데이터 삽입 용
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievedDate),
            isActive = isActive,
        )
    }

    // 데이터 수정 용
    fun toEntity(id: Long): Achievement {
        val achievement = this.toEntity()
        achievement.id = id

        return achievement
    }



}
