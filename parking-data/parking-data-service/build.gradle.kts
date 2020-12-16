val mapstructVersion: String? by ext
val mapstructKotlinVersion: String? by ext

dependencies {
  implementation(project(":parking-data:parking-data-api"))
  implementation("org.springframework.boot:spring-boot-starter-web") {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
  }
  implementation("p6spy:p6spy:3.9.1")
  implementation("com.baomidou:mybatis-plus-boot-starter:3.4.1")
  implementation("org.springframework.boot:spring-boot-starter-undertow")

  api("org.mapstruct:mapstruct:${mapstructVersion}")
  kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  runtimeOnly("org.postgresql:postgresql")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

}
