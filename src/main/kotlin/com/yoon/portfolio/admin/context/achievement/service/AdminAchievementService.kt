package com.yoon.portfolio.admin.context.achievement.service

import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}