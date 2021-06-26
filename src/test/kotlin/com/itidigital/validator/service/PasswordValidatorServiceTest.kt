package com.itidigital.validator.service

import com.itidigital.validator.domain.ValidatorResponse
import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum
import com.itidigital.validator.service.validators.IsValidPasswordService
import com.itidigital.validator.service.validators.PasswordStrongLevelService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PasswordValidatorServiceTest(
    @Autowired val passwordStrongLevelService: PasswordStrongLevelService,
    @Autowired val isValidPasswordService: IsValidPasswordService,
    @Autowired val passwordValidatorService: PasswordValidatorService
) {

    companion object {
        const val strongPassword = "AbTp9!fogV45k"
        const val mediumPassword = "AbTp9!fogV"
        const val weakPassword = "AbTp9!fog"
        const val invalidPassword = ""

        @BeforeAll
        fun setup() {
            val passwordStrongLevelServiceMock = Mockito.mock(PasswordStrongLevelService::class.java)
            Mockito.`when`(passwordStrongLevelServiceMock.getPasswordStrongLevel(strongPassword))
                .thenReturn(PasswordStrongLevelEnum.STRONG)
            Mockito.`when`(passwordStrongLevelServiceMock.getPasswordStrongLevel(mediumPassword))
                .thenReturn(PasswordStrongLevelEnum.STRONG)
            Mockito.`when`(passwordStrongLevelServiceMock.getPasswordStrongLevel(weakPassword))
                .thenReturn(PasswordStrongLevelEnum.STRONG)

            val isValidPasswordServiceMock = Mockito.mock(IsValidPasswordService::class.java)
            Mockito.`when`(isValidPasswordServiceMock.validate(strongPassword)).thenReturn(true)
            Mockito.`when`(isValidPasswordServiceMock.validate(mediumPassword)).thenReturn(false)
            Mockito.`when`(isValidPasswordServiceMock.validate(weakPassword)).thenReturn(false)
        }
    }

    @Test
    fun shouldBeAValidAndStrongPassword() {
        val result = passwordValidatorService.validate(PasswordValidatorServiceTest.strongPassword)

        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.STRONG))
    }

    @Test
    fun shouldBeAValidAndMediumPassword() {
        val result = passwordValidatorService.validate(PasswordValidatorServiceTest.mediumPassword)

        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.MEDIUM))
    }

    @Test
    fun shouldBeAValidAndWeakPassword() {
        val result = passwordValidatorService.validate(PasswordValidatorServiceTest.weakPassword)

        Assertions.assertEquals(result, ValidatorResponse(true, PasswordStrongLevelEnum.WEAK))
    }

    @Test
    fun shouldBeAInvalidPassword() {
        val result = passwordValidatorService.validate(PasswordValidatorServiceTest.invalidPassword)

        Assertions.assertEquals(result, ValidatorResponse(false, null))
    }

}