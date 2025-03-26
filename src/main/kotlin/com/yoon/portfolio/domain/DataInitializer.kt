package com.yoon.portfolio.domain

import com.yoon.portfolio.domain.constant.SkillType
import com.yoon.portfolio.domain.entity.*
import com.yoon.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {

    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData(){

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        //achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "컴퓨터활용능력 1급",
                description = "엑세, 엑세스",
                host = "대한상공회의소",
                achievedDate = LocalDate.of(2021, 12, 1),
                isActive = true
            ),
            Achievement(
                title = "네트워크관리사 2급",
                description = "네트워크 설계/구축, TCP/IP, 네트워크 운용기기 등",
                host = "한국정보통신자격협회",
                achievedDate = LocalDate.of(2021, 12, 1),
                isActive = true
            )
        )
        //데이터베이스에 저장
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "성실하게 배우고 일하는 프로그래머 입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )

        introductionRepository.saveAll(introductions)

        //link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/pyy2114", isActive = true),
        )
        linkRepository.saveAll(links)

        //experience, experience detail 초기화
        val experience1 = Experience(
            title = "가톨릭대학교",
            description = "컴퓨터 공학 전공",
            startYear = 2021,
            startMonth = 3,
            endYear = 2025,
            endMonth = 8,
            isActive = true
        )

        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 3.4/4.5", isActive = true),
                ExperienceDetail(content = "알고리즘 동호회 활동", isActive = true),
            )
        )

        val experience2 = Experience(
            title = "응용 솔루션 업체",
            description = "펌웨어 개발",
            startYear = 2017,
            startMonth = 12,
            endYear = 2021,
            endMonth = 7,
            isActive = true
        )

        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "USB 현미경 AF 알고리즘 개발", isActive = true),
                ExperienceDetail(content = "카메라 이미지 처리를 위한 ISP 펌웨어 개발", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        //skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = false)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = false)
        val Git = Skill(name = "Git", type = SkillType.TOOL.name, isActive = true)

        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka, Git))

        //project, projectDetail, projectSkill 초기화
        val project1 = Project(
            name = "풋살 팀 매칭 서비스",
            description = "풋살 팀 매칭 및 구장 예약 서비스, 팀을 생성하여 팀원들과 풋살 일정을 관리할 수 있고 " +
                    "경기 조건이 맞는 팀과의 매칭 및 예약을 도와주는 서비스 개발.",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 10,
            isActive = true
        )

        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "풋살팀 관리 API 및 팀원 관리 API 개발", url = null, isActive = true),
            )
        )

        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis)
            )
        )
//        val project2 = Project(
//            name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
//            description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업.",
//            startYear = 2022,
//            startMonth = 12,
//            endYear = null,
//            endMonth = null,
//            isActive = true
//        )
//
//        project2.addDetails(
//            mutableListOf(
//                ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발", url = null, isActive = true),
//                ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
//                ProjectDetail(content = "Githun Repository", url = "https://", isActive = true)
//            )
//        )
//
//        project2.skills.addAll(
//            mutableListOf(
//                ProjectSkill(project = project2, skill = python),
//                ProjectSkill(project = project2, skill = django),
//                ProjectSkill(project = project2, skill = kafka)
//            )
//        )

//        projectRepository.saveAll(mutableListOf(project1, project2))
        projectRepository.saveAll(mutableListOf(project1))

        val account = Account(
            loginId = "admin",
            pw = "\$2a\$10\$SmWia2X5hczreiXHPwE1/eZaK50OB8uTHMct.D3lJnuI7RxGzs7rO"
        )

        accountRepository.save(account)
    }
}