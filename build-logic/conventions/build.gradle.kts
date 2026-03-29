plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    val springBootVersion = libs.versions.springBoot.get()
    val springDepMgmtVersion = libs.versions.springDependencyManagement.get()
    val jibVersion = libs.versions.jib.get()
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:$springDepMgmtVersion")
    implementation("com.google.cloud.tools.jib:com.google.cloud.tools.jib.gradle.plugin:$jibVersion")
}
