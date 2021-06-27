package com.itidigital.validator.controller.v1

import com.itidigital.validator.domain.ValidatorResponse
import com.itidigital.validator.dtos.ValidatePasswordRequest
import com.itidigital.validator.service.PasswordValidatorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1")
class ValidatorController(
    val passowordValidatorService: PasswordValidatorService
) {

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    fun validator(@RequestBody payload : ValidatePasswordRequest) : ValidatorResponse {
        return passowordValidatorService.validate(payload.password)
    }

}