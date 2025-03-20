package com.yoon.portfolio.admin.context.skill.service

import com.yoon.portfolio.admin.context.link.form.LinkForm
import com.yoon.portfolio.admin.context.skill.form.SkillForm
import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.admin.exception.AdminBadRequestException
import com.yoon.portfolio.domain.constant.SkillType
import com.yoon.portfolio.domain.entity.Link
import com.yoon.portfolio.domain.entity.Skill
import com.yoon.portfolio.domain.repository.SkillRepository
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {
    // 데이터 조회
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    //데이터 삽입
    @Transactional
    fun save(form: SkillForm){
        val skillType = SkillType.valueOf(form.type)

        skillRepository.findByNameIgnoreCaseAndType(form.name, skillType)
            .ifPresent{ throw AdminBadRequestException("중복된 데이터입니다.") }

        val skill = form.toEntity()
        skillRepository.save(skill)
    }

    //데이터 수정
    @Transactional
    fun update(id: Long, form:SkillForm){
        val skill = form.toEntity(id)
        skillRepository.save(skill)
    }

}