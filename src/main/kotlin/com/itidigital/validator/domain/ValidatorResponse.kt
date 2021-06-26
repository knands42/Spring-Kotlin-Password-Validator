package com.itidigital.validator.domain

import com.itidigital.validator.domain.enum.PasswordStrongLevelEnum

data class ValidatorResponse (val isValidPassword : Boolean, val strongLevel: PasswordStrongLevelEnum?)