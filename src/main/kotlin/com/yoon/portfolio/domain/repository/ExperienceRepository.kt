package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ExperienceRepository : JpaRepository<Experience, Long> {
    // select * from Experience where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    override fun findById(id: Long): Optional<Experience>
}