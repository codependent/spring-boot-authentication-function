package com.codependent.springcloud.function.authentication

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.codependent.micronaut.aws.authentication.dto.AuthenticationResponse
import com.codependent.micronaut.aws.authentication.dto.Credentials
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class SpringBootAuthenticationFunctionApplication {

    @Bean
    fun kotlinSupplier(): (Credentials) -> AuthenticationResponse {

        return {
            if (it.user == "jose" && it.password == "MyPassword") {
                //HMAC
                val algorithm = Algorithm.HMAC256("secret")
                val token = JWT.create()
                        .withIssuer("MicronautAwsAuthenticationFunction")
                        .withSubject(it.user)
                        .sign(algorithm)
                AuthenticationResponse(token)
            } else {
                AuthenticationResponse()
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootAuthenticationFunctionApplication>(*args)
}
