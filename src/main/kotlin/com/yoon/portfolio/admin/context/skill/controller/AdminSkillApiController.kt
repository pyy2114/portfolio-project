package com.yoon.portfolio.admin.context.skill.controller

import com.yoon.portfolio.admin.context.skill.form.SkillForm
import com.yoon.portfolio.admin.context.skill.service.AdminSkillService
import com.yoon.portfolio.admin.data.ApiResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/skills")
class AdminSkillApiController(
    private val adminSkillService: AdminSkillService
) {

    @PostMapping
    fun postSkill(@RequestBody @Valid form: SkillForm):ResponseEntity<Any>{
        adminSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun postSkill(@RequestBody form: SkillForm, @PathVariable id: Long):ResponseEntity<Any>{
        adminSkillService.update(id, form)

        return ApiResponse.successUpdate()
    }
}