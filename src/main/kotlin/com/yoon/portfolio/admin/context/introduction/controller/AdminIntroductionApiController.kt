package com.yoon.portfolio.admin.context.introduction.controller

import com.yoon.portfolio.admin.context.introduction.form.IntroductionForm
import com.yoon.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.yoon.portfolio.admin.data.ApiResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {

    @PostMapping
    fun postIntroduction(@Valid @RequestBody form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putIntroduction(@RequestBody form: IntroductionForm, @PathVariable id: Long): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)
        return ApiResponse.successUpdate()
    }
}