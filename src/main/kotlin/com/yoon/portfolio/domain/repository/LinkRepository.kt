package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Introduction
import com.yoon.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {
    // select * from Link where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Link>
}