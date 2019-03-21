package com.codependent.micronaut.aws.authentication.dto

class AuthenticationResponse(val token: String) {
    constructor() : this("")
}
