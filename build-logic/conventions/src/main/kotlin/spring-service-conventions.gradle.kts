plugins {
    id("java-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("com.google.cloud.tools.jib")
}

val imageRegistry = providers.gradleProperty("imageRegistry").orNull
val imageRepository = providers.gradleProperty("imageRepository").orNull
val imageTags = providers.gradleProperty("imageTags")
    .orNull
    ?.split(",")
    ?.map { it.trim() }
    ?.filter { it.isNotEmpty() }
    ?.toSet()

val imageName = if (!imageRegistry.isNullOrBlank() && !imageRepository.isNullOrBlank()) {
    "${imageRegistry}/${imageRepository}/${project.name}".lowercase()
} else {
    "charity-connect/${project.name}"
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
        image = imageName
        tags = imageTags ?: setOf("latest", project.version.toString())
    }
    container {
        // Keep deterministic output for maximum layer reuse across rebuilds.
        creationTime = "EPOCH"
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
