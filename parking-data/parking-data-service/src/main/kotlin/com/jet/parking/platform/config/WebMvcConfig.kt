package com.jet.parking.platform.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {

  override fun addCorsMappings(registry: CorsRegistry) {
    registry.addMapping("/*")
      .allowCredentials(true)
      .allowedHeaders("*")
      .allowedMethods("*")
      .allowedOrigins("*")
  }

}