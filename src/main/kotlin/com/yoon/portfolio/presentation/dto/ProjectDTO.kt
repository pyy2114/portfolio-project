package com.yoon.portfolio.presentation.dto

import com.yoon.portfolio.domain.entity.Project

class ProjectDTO(
    val name: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String?,
    val details: List<ProjectDetailDTO>,
    val skills: List<SkillDTO>?
) {
    constructor(project: Project) : this(
        name = project.name,
        description = project.description,
        startYearMonth = "${project.startYear}.${project.startMonth}",
        endYearMonth = project.getEndYearMonth(),
        //details = project.details.map{detail -> ProjectDetailDTO(detail)},
        //활성화 상태인 디테일 데이터만 필터를 해옴
        details = project.details.filter{ it.isActive }.map{ ProjectDetailDTO(it)},
        //skills = project.skills.map{projectSkill -> SkillDTO(projectSkill.skill)}
        skills = project.skills.map{it.skill}.filter{it.isActive}.map{SkillDTO(it)}
    )
}