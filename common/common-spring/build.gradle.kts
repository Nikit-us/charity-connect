plugins {
    id("spring-library-conventions")
}

group = "com.mdl"
version = "1.0-SNAPSHOT"

dependencies {
    api(project(":common:common-core"))

    implementation("org.springframework.boot:spring-boot-starter")
}
