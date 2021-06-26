package com.itidigital.validator.service.validators

import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PasswordStrongLevelTest(
    @Autowired val passwordStrongLevelService: PasswordStrongLevelService
) {

    private val strongPassword = "AbTp9!fogV45k"
    private val mediumPassword = "AbTp9!fogV"
    private val weakPassword = "AbTp9!fog"

    @Test
    fun shouldValidateAPasswordAsStrong() {
        val result = passwordStrongLevelService.getPasswordStrongLevel(strongPassword)
        Assertions.assertEquals(result, PasswordStrongLevelEnum.STRONG)
    }

    @Test
    fun shouldValidateAPasswordAsMedium() {
        val result = passwordStrongLevelService.getPasswordStrongLevel(mediumPassword)
        Assertions.assertEquals(result, PasswordStrongLevelEnum.MEDIUM)
    }

    @Test
    fun shouldValidateAPasswordAsWeak() {
        val result = passwordStrongLevelService.getPasswordStrongLevel(weakPassword)
        Assertions.assertEquals(result, PasswordStrongLevelEnum.WEAK)
    }
}