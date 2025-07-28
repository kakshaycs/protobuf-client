package com.example.demo.controller

import com.example.demo.proto.UserDetailsProto
import com.example.demo.service.UserApiClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client/user")
class UserClientController(
    private val userApiClientService: UserApiClientService
) {
    @GetMapping("/protobuf")
    fun getUserProtobuf(): UserDetailsProto.UserDetails? = userApiClientService.getUserAsProtobuf()

    @GetMapping("/json")
    fun getUserJson(): UserDetailsProto.UserDetails? = userApiClientService.getUserAsJson()
} 