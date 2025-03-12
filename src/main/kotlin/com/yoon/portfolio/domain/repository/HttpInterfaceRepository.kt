package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    //매개변수로 들어온 날짜 사이에 생성날짜가 있는 것을 모두 카운트
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long
}