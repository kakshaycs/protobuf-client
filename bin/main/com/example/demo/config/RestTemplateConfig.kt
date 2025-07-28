package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {
    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        // Add Protobuf converter after default converters (Jackson for JSON)
        restTemplate.messageConverters.add(ProtobufHttpMessageConverter())
        return restTemplate
    }
} 