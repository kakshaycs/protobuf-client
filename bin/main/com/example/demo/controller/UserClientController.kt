package com.example.demo.controller

import com.example.demo.dto.UserDetailsDto
import com.example.demo.service.UserApiClientService
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client/user")
class UserClientController(
    private val userApiClientService: UserApiClientService
) {
    @GetMapping("/protobuf")
    fun getUserProtobuf(): UserDetailsDto? =
        userApiClientService.getUserAsProtobuf()?.toDto()

    @GetMapping("/json")
    fun getUserJson(): UserDetailsDto?{
        val data = userApiClientService.getUserAsJsonNode()

        return jacksonObjectMapper().convertValue<UserDetailsDto>(data)
    }
}

// Extension function to map Protobuf to DTO
fun com.example.demo.proto.UserDetailsProto.UserDetails.toDto() = UserDetailsDto(
    id = this.id,
    name = this.name,
    email = this.email,
    age = this.age,
    isActive = this.isActive,
    accountBalance = this.accountBalance,
    userType = this.userType.name,
    phoneNumbers = this.phoneNumbersList,
    address = this.address
) 