package com.yoon.portfolio.admin.context.introduction.service

import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.entity.Introduction
import com.yoon.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}