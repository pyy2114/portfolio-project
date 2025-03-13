package com.yoon.portfolio.presentation.dto

import com.yoon.portfolio.domain.entity.Achievement
import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

class ResumeDTO(
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills: List<Skill>
) {
    var experiences: List<ExperienceDTO> = experiences.map{it ->
        ExperienceDTO(
            title = it.title,
            description = it.description,
            startYearMonth = "${it.startYear}.${it.startMonth}",
            endYearMonth = it.getEndYearMonth(),
            details = it.details.filter{it.isActive}.map{it.content}
            //필터링을 여기서 해주는 이유
            /**
             * experience 레포지토리에서 left join 해서 가져오는데 저 isActive 조건이
             * experience만 걸리고 details에는 안걸려있어서
             */
        )
    }

    var achievements: List<AchievementDTO> = achievements.map {it ->
        AchievementDTO(
            title = it.title,
            description = it.description,
            host = it.host,
            achievedDate = it.achievedDate
            ?.format(DateTimeFormatter.ISO_LOCAL_DATE) //null이 아니면 formatting해줄거다
            ?.replace("-", ".")
            // yyyy-mm-dd -> yyyy.mm.dd
        )
    }

    var skills: List<SkillDTO> = skills.map{SkillDTO(it)}
}