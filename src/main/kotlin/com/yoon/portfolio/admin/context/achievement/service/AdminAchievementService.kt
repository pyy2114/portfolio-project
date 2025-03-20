package com.yoon.portfolio.admin.context.achievement.service

import com.yoon.portfolio.admin.context.achievement.form.AchievementForm
import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.repository.AchievementRepository
import com.yoon.portfolio.presentation.dto.AchievementDTO
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {
    // 데이터 조회
    fun getAchievementTable(): TableDTO{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 데이터 삽입
    @Transactional
    fun save(form: AchievementForm){
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    // 데이터 수정
    @Transactional
    fun update(id: Long, form: AchievementForm){
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}