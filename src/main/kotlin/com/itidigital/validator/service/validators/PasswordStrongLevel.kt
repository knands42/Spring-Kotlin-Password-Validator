package com.itidigital.validator.service.validators

import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum
import org.springframework.stereotype.Component

@Component
class PasswordStrongLevelService() : BaseValidators() {

    fun getPasswordStrongLevel(password: String): PasswordStrongLevelEnum {

        val rulesToValidateInOrder = listOf<(password: String) -> Boolean>(
            this::hasOneDigit,
            this::hasOneLowerCaseLetter,
            this::hasOneUpperCaseLetter,
            this::hasSpecialCharacterLetter,
            this::hasNoRepeatingCharacters,
            this::hasMoreThanNineCharacters,
            this::hasMoreThanOneDigit,
            this::hasMoreThanSixLowerCaseLetter,
            this::hasMoreThanThreeUpperCaseLetter,
            this::hasNoSpaces,
            )

        var counter: Int = 0
        for (validation in rulesToValidateInOrder) {
            val isValid = validation(password)
            if (isValid) counter++
        }

        return when {
            counter >= 10 -> PasswordStrongLevelEnum.STRONG
            counter >= 8 -> PasswordStrongLevelEnum.MEDIUM
            else -> PasswordStrongLevelEnum.WEAK
        }
    }

}