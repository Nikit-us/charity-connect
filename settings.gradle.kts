rootProject.name = "charity-connect"

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}

include("common-lib")
include("user-service")

project(":common-lib").projectDir = file("common/common-lib")
project(":user-service").projectDir = file("services/user-service")