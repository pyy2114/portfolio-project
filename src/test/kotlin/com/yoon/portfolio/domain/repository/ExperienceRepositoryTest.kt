package com.yoon.portfolio.domain.repository

import com.yoon.portfolio.domain.entity.Experience
import com.yoon.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest (
    @Autowired val experienceRepository: ExperienceRepository
){

    val DATA_SIZE = 10

    //더미 객체 생성
    /**
     * 더미 데이터 객체를 만들어줄 메서드
     */
    private fun createExperience(n: Int): Experience{
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 {n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()

        for(i in 1..n){
            val experienceDetail = ExperienceDetail(content = "테스트 ${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)

        return experience
    }

    //테스트 데이터 초기화
    /**
     * 위에서 만든 더미 데이터 메서드를 DAT_SIZE만큼 실행 시켜서 리스트에 저장 후
     * 레포지토리에 save --> 더미 객체 생성 완
     */
    @BeforeAll
    fun beforeAll(){
        println("---- 데이터 초기화 이전 조회 시작 ----")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        println("---- 데이터 초기화 이전 조회 종료 ----")


        println("---- 데이터 초기화 이전 조회 시작 ----")
        val experiences = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE) {
            val experience = createExperience(i)
            experiences.add(experience)
        }

        experienceRepository.saveAll(experiences)
        println("---- 데이터 초기화 이전 조회 종료 ----")
    }

    /**
     * 위에서 생성된 객체들이 제대로 테스트 되는지 테스트
     */
    @Test
    fun testFindAll(){
        println("---- findAll 테스트 시작 ----")
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experience.size: ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }

        println("---- findAll 테스트 종료 ----")

    }

    @Test
    fun testFindAllByIsActive(){
        println("---- findAllByIsActive 테스트 시작 ----")
        val experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experiences.size : ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }
        println("---- findAllByIsActive 테스트 종료 ----")
    }

//    //조인 테스트 --> 강의 자료엔 없음(push 전에 주석 처리)
//    @Test
//    fun testJoinQuery(){
//        val findById = experienceRepository.findById(1)
//        println(findById.isPresent)
//    }


}