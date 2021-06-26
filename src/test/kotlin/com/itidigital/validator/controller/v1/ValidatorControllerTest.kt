package com.itidigital.validator.controller.v1

import com.itidigital.validator.domain.ValidatorResponse
import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum
import com.itidigital.validator.service.PasswordValidatorService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatorControllerTest(
    @Autowired val passowordValidatorService: PasswordValidatorService
) {

    @Test
    fun shouldGetAValidStrongPassword() {
        val result = passowordValidatorService.validate(password = "AbTp9!fogV45k")
        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.STRONG))
    }

    @Test
    fun shouldGetAValidMediumPassword() {
        val result = passowordValidatorService.validate(password = "AbTp9!fogV")
        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.MEDIUM))
    }

    @Test
    fun shouldGetAValidWeakPassword() {
        val result = passowordValidatorService.validate(password = "AbTp9!fog")
        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.WEAK))
    }

    @Test
    fun shouldGetAInvalidPassword() {
        val result = passowordValidatorService.validate(password = "ss")
        Assertions.assertEquals(result, ValidatorResponse(false, null))
    }

}