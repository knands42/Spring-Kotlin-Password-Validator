package com.itidigital.validator.service

import com.itidigital.validator.domain.ValidatorResponse
import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum
import com.itidigital.validator.service.validators.IsValidPasswordService
import com.itidigital.validator.service.validators.PasswordStrongLevelService
import org.springframework.stereotype.Component

@Component
class PasswordValidatorService(
    private val passwordStrongLevelService: PasswordStrongLevelService,
    private val isValidPasswordService: IsValidPasswordService
) {

    fun validate(password: String): ValidatorResponse {
        val isValid = validatePassword(password)
        if (!isValid) return ValidatorResponse(false, null)

        val passwordLevel = validatePasswordStrong(password)

        return ValidatorResponse(isValid, passwordLevel)
    }

    private fun validatePasswordStrong(password: String): PasswordStrongLevelEnum {
        return passwordStrongLevelService.getPasswordStrongLevel(password)
    }

    private fun validatePassword(password: String): Boolean {
        return isValidPasswordService.validate(password)
    }
}