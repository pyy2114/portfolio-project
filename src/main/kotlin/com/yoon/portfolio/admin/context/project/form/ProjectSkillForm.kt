package com.yoon.portfolio.admin.context.project.form

import com.yoon.portfolio.admin.context.skill.form.SkillForm
import com.yoon.portfolio.domain.entity.Project
import jakarta.validation.constraints.NotBlank

data class ProjectSkillForm(

    @field:NotBlank(message = "필수값입니다.")
    val project: String,

    @field:NotBlank(message = "필수값입니다.")
    val skill: String
)
