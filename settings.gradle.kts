pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "charity-connect"

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}

// common modules
include("common:common-core")
include("common:common-spring")

// services
include("services:user-service")
