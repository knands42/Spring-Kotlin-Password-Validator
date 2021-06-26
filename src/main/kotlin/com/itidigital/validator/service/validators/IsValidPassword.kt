package com.itidigital.validator.service.validators

import org.springframework.stereotype.Component

@Component
class IsValidPasswordService : BaseValidators() {

    fun validate(password: String) : Boolean {

        val rulesToValidate = listOf<(password: String) -> Boolean>(
            this::hasOneDigit,
            this::hasOneLowerCaseLetter,
            this::hasOneUpperCaseLetter,
            this::hasSpecialCharacterLetter,
            this::hasNoRepeatingCharacters,
            this::hasNoSpaces,
        )

        for (validation in rulesToValidate) {
            val validationResult = validation(password)
            if (!validationResult) return false
        }

        return true

    }


}