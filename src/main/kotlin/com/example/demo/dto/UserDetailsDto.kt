package com.example.demo.dto

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