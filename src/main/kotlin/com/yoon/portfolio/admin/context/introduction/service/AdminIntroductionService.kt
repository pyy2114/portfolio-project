package com.yoon.portfolio.admin.context.introduction.service

import com.yoon.portfolio.admin.context.introduction.form.IntroductionForm
import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.entity.Introduction
import com.yoon.portfolio.domain.repository.IntroductionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    // 데이터 조회
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 데이터 삽입
    @Transactional
    fun save(form: IntroductionForm) {
        val introduction = form.toEntity()
        introductionRepository.save(introduction)
    }

    // 데이터 수정
    @Transactional
    fun update(id: Long, form: IntroductionForm) {
        val introduction = form.toEntity(id)
        introductionRepository.save(introduction)
    }
}