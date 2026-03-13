plugins {
    java
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

java {
    toolchain {
        val javaVersion = libs.findVersion("java").get().requiredVersion
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

dependencies {
    add("compileOnly", libs.findLibrary("lombok").get())
    add("annotationProcessor", libs.findLibrary("lombok").get())

    add("testImplementation", platform(libs.findLibrary("junit-bom").get()))
    add("testImplementation", libs.findLibrary("junit-jupiter").get())
    add("testRuntimeOnly", libs.findLibrary("junit-platform-launcher").get())
}

tasks.withType<Test> {
    useJUnitPlatform()
}