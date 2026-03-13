plugins {
    id("conventions")
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.jib)
}


group = "com.mdl"
version = "0.0.1-SNAPSHOT"
description = "user-service"

dependencies {
    implementation(project(":common-lib"))

    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.security.oauth2.resource.server)

    developmentOnly(libs.spring.boot.devtools)

    testImplementation(libs.spring.boot.starter.webmvc.test)
}

jib {
    from {
        image = "eclipse-temurin:21-jre-alpine"
        platforms {
            platform {
                architecture = "amd64"
                os = "linux"
            }
        }
    }
    to {
        image = "charity-connect/${project.name}"
        tags = setOf("latest", project.version.toString())
    }
    container {
        creationTime = "USE_CURRENT_TIMESTAMP"
        jvmFlags = listOf(
            "-XX:+UseContainerSupport",
            "-XX:MaxRAMPercentage=75.0",
            "-XX:+ExitOnOutOfMemoryError",
            "-Djava.security.egd=file:/dev/./urandom"
        )
        environment = mapOf(
            "SPRING_OUTPUT_ANSI_ENABLED" to "NEVER"
        )
    }
}