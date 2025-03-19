package com.yoon.portfolio.admin.context.experience.controller

import com.yoon.portfolio.admin.context.experience.service.AdminExperienceService
import com.yoon.portfolio.admin.data.DateFormElementDTO
import com.yoon.portfolio.admin.data.FormElementDTO
import com.yoon.portfolio.admin.data.SelectFormElementDTO
import com.yoon.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/experience")
class AdminExperienceViewController(
    private val adminExperienceService: AdminExperienceService
) {

    @GetMapping
    fun experience(model: Model): String{
        //FORM 요소 세팅
        val elements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            SelectFormElementDTO("startYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )

        model.addAttribute("elements",elements)

        //테이블 정보 세팅
        val table = adminExperienceService.getExperienceTable()
        model.addAttribute("table", table)

        //상세 테이블 정보 세팅
        val detailTable = adminExperienceService.getExperienceDetailTable(null)
        model.addAttribute("detailTable", detailTable)

        //페이지 속성 세팅
        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
        )

        model.addAttribute(pageAttributes)

        return "admin/page-table"
    }
}