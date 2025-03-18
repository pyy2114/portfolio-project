package com.yoon.portfolio.admin.advice

import com.yoon.portfolio.admin.exception.AdminException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AdminApiControllerAdvice {

    val log  = LoggerFactory.getLogger(AdminApiControllerAdvice::class.java)

    @ExceptionHandler
    fun handleException(e: AdminException): ResponseEntity<String>{
        log.info(e.message, e)

        return ResponseEntity.status(e.httpStatus).body(e.message)
    }

    @ExceptionHandler
    fun handleException(e: MethodArgumentNotValidException): ResponseEntity<String>{
        log.info(e.message, e)

        //bindingResult 안에 오류 정보가 담겨져 있음
        val fieldError = e.bindingResult.fieldErrors[0]
        val message = "[${fieldError.field}] ${fieldError.defaultMessage}"

        return ResponseEntity.badRequest().body(message)
    }

    @ExceptionHandler
    fun handleException(e: Exception): ResponseEntity<String>{
        log.info(e.message, e)

        return ResponseEntity.internalServerError().body("시스템 오류가 발생했습니다.")
    }
}