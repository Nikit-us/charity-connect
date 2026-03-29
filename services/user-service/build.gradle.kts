plugins {
    id("spring-service-conventions")
}

group = "com.mdl"
version = "0.0.1-SNAPSHOT"
description = "user-service"

dependencies {
    implementation(project(":common:common-spring"))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.security.oauth2.resource.server)

    developmentOnly(libs.spring.boot.devtools)

    testImplementation(libs.spring.boot.starter.webmvc.test)
}
