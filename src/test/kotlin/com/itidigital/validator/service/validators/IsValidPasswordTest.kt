package com.itidigital.validator.service.validators

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class IsValidPasswordTest(
    @Autowired val isValidPasswordService: IsValidPasswordService
) {

    private val validPassword = "AbTp9!fogV45k"
    private val passwordWithoutDigit = "AbTp!fogVk"
    private val passwordWithoutLowerCaseLetter = "AT9!V45"
    private val passwordWithoutUpperCaseLetter = "bp9!fog45k"
    private val passwordWithoutSpecialCharacter = "AbTp9fogV45k"
    private val passwordWitSpaces = "AbT p9!fog V45k"

    @Test
    fun shouldValidateAsAValidPassword() {
        val result = isValidPasswordService.validate(validPassword)
        Assertions.assertEquals(result, true)
    }

    @Test
    fun shouldValidateAsInvalidPasswordWithoutDigit() {
        val result = isValidPasswordService.validate(passwordWithoutDigit)
        Assertions.assertEquals(result, false)
    }

    @Test
    fun shouldValidateAsAInvalidPasswordWithoutLowerCaseLetter() {
        val result = isValidPasswordService.validate(passwordWithoutLowerCaseLetter)
        Assertions.assertEquals(result, false)
    }

    @Test
    fun shouldValidateAsAInvalidPasswordWithoutUpperCaseLetter() {
        val result = isValidPasswordService.validate(passwordWithoutUpperCaseLetter)
        Assertions.assertEquals(result, false)
    }

    @Test
    fun shouldValidateAsAInvalidPasswordWithoutSpecialCharacter() {
        val result = isValidPasswordService.validate(passwordWithoutSpecialCharacter)
        Assertions.assertEquals(result, false)
    }

    @Test
    fun shouldValidateAsAInvalidPasswordWitSpaces() {
        val result = isValidPasswordService.validate(passwordWitSpaces)
        Assertions.assertEquals(result, false)
    }


}