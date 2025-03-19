package com.yoon.portfolio.admin.context.link.service

import com.yoon.portfolio.admin.data.TableDTO
import com.yoon.portfolio.domain.entity.Introduction
import com.yoon.portfolio.domain.entity.Link
import com.yoon.portfolio.domain.repository.IntroductionRepository
import com.yoon.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}