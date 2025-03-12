package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository : JpaRepository<Project, Long> {
    // select * from Project where is_active = :isActive
    @Query("select p from Project p left join fetch p.skills s join fetch s.skill where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    @Query("select p from Project p join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>
}