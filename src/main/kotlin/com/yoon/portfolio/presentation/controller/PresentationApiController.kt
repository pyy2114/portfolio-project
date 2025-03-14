package com.yoon.portfolio.presentation.controller

import com.yoon.portfolio.presentation.dto.IntroductionDTO
import com.yoon.portfolio.presentation.dto.LinkDTO
import com.yoon.portfolio.presentation.dto.ProjectDTO
import com.yoon.portfolio.presentation.dto.ResumeDTO
import com.yoon.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

    @GetMapping("/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    @GetMapping("/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }
}