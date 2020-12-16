import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
  mavenCentral()
}

buildscript {

  extra.apply {

  }
}

plugins {
  kotlin("jvm") version "1.3.72"
  kotlin("kapt") version "1.4.21" apply false
  kotlin("plugin.spring") version "1.3.72" apply false
  id("org.springframework.boot") version "2.3.7.RELEASE" apply false
  id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
}

allprojects {
  ext {
    set("mapstructVersion", "1.4.1.Final")
    set("mapstructKotlinVersion", "1.4.0.0")
  }
}

subprojects {

  apply(plugin = "org.jetbrains.kotlin.jvm")
  apply(plugin = "org.jetbrains.kotlin.kapt")

  repositories {
    mavenCentral()
    jcenter()
  }

  group = "com.jet"
  version = "0.0.1-SNAPSHOT"

  tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
    options.encoding = "utf-8"
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "1.8"
    }
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  }

}

project(":parking-data:parking-data-service") {
  apply(plugin = "org.jetbrains.kotlin.plugin.spring")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")
}

tasks {
  withType<Jar> {
    enabled = false
  }
}

