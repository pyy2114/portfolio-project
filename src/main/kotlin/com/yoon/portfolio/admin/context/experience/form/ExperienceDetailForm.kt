package com.yoon.portfolio.admin.context.experience.form

import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content

data class ExperienceDetailForm(

    val id: Long,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean
){
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }

}
