package com.example.demo.service

import com.example.demo.proto.UserDetailsProto
import com.fasterxml.jackson.databind.JsonNode
import com.google.protobuf.util.JsonFormat
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserApiClientService(
    private val restTemplate: RestTemplate
) {
    private val serverBaseUrl: String = "http://localhost:8080"

    fun getUserAsProtobuf(): UserDetailsProto.UserDetails? {
        val url = "$serverBaseUrl/user/protobuf"
        val headers = HttpHeaders().apply {
            accept = listOf(MediaType.parseMediaType("application/x-protobuf"))
        }
        val entity = HttpEntity<Void>(headers)
        val response: ResponseEntity<UserDetailsProto.UserDetails> = restTemplate.exchange(
            url, HttpMethod.GET, entity, UserDetailsProto.UserDetails::class.java
        )
        return response.body
    }

    fun getUserAsProtobufList(): UserDetailsProto.UserDetailsList? {
        val url = "$serverBaseUrl/users/protobuf"
        val headers = HttpHeaders().apply {
            accept = listOf(MediaType.parseMediaType("application/x-protobuf"))
        }
        val entity = HttpEntity<Void>(headers)
        val response: ResponseEntity<UserDetailsProto.UserDetailsList> = restTemplate.exchange(
            url, HttpMethod.GET, entity, UserDetailsProto.UserDetailsList::class.java
        )
        return response.body
    }

    fun getUserAsJsonNode(): JsonNode? {
        val url = "$serverBaseUrl/user/json"
        val headers = HttpHeaders().apply {
            accept = listOf(MediaType.APPLICATION_JSON)
        }
        val entity = HttpEntity<Void>(headers)
        val response: ResponseEntity<JsonNode> = restTemplate.exchange(
            url, HttpMethod.GET, entity, JsonNode::class.java
        )
        return response.body
    }
} 