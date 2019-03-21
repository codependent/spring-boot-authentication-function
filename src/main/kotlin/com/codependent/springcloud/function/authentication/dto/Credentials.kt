package com.codependent.micronaut.aws.authentication.dto

data class Credentials(var user: String, var password: String) {
    constructor() : this("", "")
}
