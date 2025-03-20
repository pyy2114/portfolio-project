package com.yoon.portfolio.admin.context.link.service

import com.yoon.portfolio.admin.context.link.form.LinkForm
import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Introduction
import com.yoon.portfolio.domain.entity.Link
import com.yoon.portfolio.domain.repository.IntroductionRepository
import com.yoon.portfolio.domain.repository.LinkRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    // 데이터 조회
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 데이터 삽입
    @Transactional
    fun save(form: LinkForm){
        val link = form.toEntity()
        linkRepository.save(link)
    }

    // 데이터 수정
    fun update(id: Long, form: LinkForm){
        val link = form.toEntity(id)
        linkRepository.save(link)
    }
}