package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDetailsDto(
    val id: Long,
    val name: String,
    val email: String,
    val age: Int,
    val isActive: Boolean,
    val accountBalance: Double,
    val userType: String,
    val phoneNumbers: List<String>,
    val address: String?
) 