import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    kotlin("jvm") version "2.0.21"
}

group = "me.erikthered"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

kotlin {
    jvmToolchain(22)
}

tasks.test {
    useJUnitPlatform()
}