package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectRepository : JpaRepository<Project, Long> {
    // select * from Project where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Project>

    override fun findById(id: Long): Optional<Project>
}