val mapstructVersion: String? by ext
val mapstructKotlinVersion: String? by ext

configurations {
  all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
  }
}

dependencies {
  implementation(project(":parking-data:parking-data-api"))
  implementation(project(":parking-data:parking-data-service"))

  implementation("org.springframework.boot:spring-boot-starter-web") {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
  }
  implementation("org.springframework.boot:spring-boot-starter-log4j2")
  implementation("org.springframework.boot:spring-boot-starter-undertow")

  implementation("org.mapstruct:mapstruct:${mapstructVersion}")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

}
