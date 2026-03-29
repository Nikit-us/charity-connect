val serviceProjects = subprojects.filter { it.path.startsWith(":services:") }

tasks.register("jibDockerBuildAll") {
    group = "container"
    description = "Build Docker images for all service projects in the local Docker daemon."
    dependsOn(serviceProjects.map { "${it.path}:jibDockerBuild" })
}

tasks.register("jibAll") {
    group = "container"
    description = "Build and push container images for all service projects."
    dependsOn(serviceProjects.map { "${it.path}:jib" })
}
