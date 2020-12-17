val mapstructVersion: String? by ext
val mapstructKotlinVersion: String? by ext

dependencies {
  implementation(project(":parking-data:parking-data-api"))

  implementation("org.springframework.boot:spring-boot-starter-web") {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
  }
  implementation("org.mybatis:mybatis-typehandlers-jsr310:1.0.2")
  implementation("p6spy:p6spy:3.9.1")
  implementation("com.baomidou:mybatis-plus-boot-starter:3.4.1")
  implementation("org.springframework.boot:spring-boot-starter-undertow")
  implementation("org.mapstruct:mapstruct:${mapstructVersion}")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")
  runtimeOnly("org.postgresql:postgresql")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

}
