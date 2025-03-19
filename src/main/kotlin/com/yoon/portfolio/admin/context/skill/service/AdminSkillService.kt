package com.yoon.portfolio.admin.context.skill.service

import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Link
import com.yoon.portfolio.domain.entity.Skill
import com.yoon.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

}