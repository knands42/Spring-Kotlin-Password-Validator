package com.itidigital.validator.controller.v1

import com.itidigital.validator.domain.ValidatorResponse
import com.itidigital.validator.dtos.ValidatePasswordRequest
import com.itidigital.validator.service.PasswordValidatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ValidatorController(
    val passowordValidatorService: PasswordValidatorService
) {

    @PostMapping("/verify")
    fun validator(@RequestBody payload : ValidatePasswordRequest) : ValidatorResponse {
        return passowordValidatorService.validate(payload.password)
    }

}