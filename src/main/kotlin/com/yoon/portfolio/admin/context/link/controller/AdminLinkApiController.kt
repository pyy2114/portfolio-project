package com.yoon.portfolio.admin.context.link.controller

import com.yoon.portfolio.admin.context.link.form.LinkForm
import com.yoon.portfolio.admin.context.link.service.AdminLinkService
import com.yoon.portfolio.admin.data.ApiResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/links")
class AdminLinkApiController(
    private val adminLinkService: AdminLinkService
) {

    @PostMapping
    fun postLink(@Valid @RequestBody form: LinkForm): ResponseEntity<Any> {
        adminLinkService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putLink(@PathVariable id: Long, @RequestBody form: LinkForm): ResponseEntity<Any> {
        adminLinkService.update(id,form)
        return ApiResponse.successUpdate()
    }
}