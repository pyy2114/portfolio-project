package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {
    // select * from Introduction where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Introduction>
}