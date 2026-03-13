# Documentation

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Charity-Connect System](#charity-connect-system)
    - [Requirements](#requirements)
        - [Java](#java)
        - [Gradle](#gradle)
        - [Docker](#docker)
        - [Postman](#postman)
    - [Core containers](#core-containers)
    - [Swagger Endpoints](#swagger-endpoints)
    - [Credentials](#credentials)
      - [PostgreSQL](#postgreSQL)
      - [Keycloak](#keycloak)
- [Postman](#postman)

<a id="introduction"></a>
# Introduction



<a id="project-structure"></a>
# Project Structure

Project has the following structure:
<pre><code>
├── common                               # Set of common modules that can be used for other modules
├── docker                               # Set of modules to start up docker containers
├── services                             # Set of core modules
|   └── user-service                     # User RESTfull web service
├── tool                                 # Tools and utilities
|   └── postman                          # Postman files
└── README.md                            # Project readme file
</code></pre>

<a id="charity-connect-system"></a>
# Charity-Connect System

<a id="icharity-connect-system"></a>
## Requirements

Install the following components to your local environment:

- **Java:** 21.0
- **Gradle:** 9.0.0
- **Docker:** 29.3.x or higher
- **Postman** 11.x or higher

<a id="java"></a>
### Java

- Download Java JDK from https://jdk.java.net/java-se-ri/21
- Setup JAVA_HOME
- Setup PATH to Java

<a id="gradle"></a>
### Gradle

- Install Gradle from https://gradle.org/releases/#9.0.0
- Add the path to the Maven bin folder to the PATH environment variable

<a id="docker"></a>
### Docker

- Install Docker Desktop from https://docs.docker.com/desktop/windows/install/

<a id="postman"></a>
### Postman

- Home site: https://www.postman.com/
- Download and install.

<a id="core-containers"></a>
## Core containers

- Build the project

      gradle clean build

- Build the docker images

      gradle jibDockerBuild

- Run the project

      docker compose up -d --build

- Check that all containers are started

      docker compose ps

- View logs

      docker compose logs -f <service-name>  //e.g. docker-compose logs -f user-service"

<a id="swagger-endpoints"></a>
## Swagger Endpoints

API Documentation is generated automatically.
Swagger UI is being generated in runtime and requires no extra configuration. It is available immediately after the
application startup.

### Local



<a id="credentials"></a>
## Credentials

<a id="postgresSQL"></a>
### Postgresql

    username: postgres
    password: postgres

<a id="keycloak-credentials"></a>
### Keycloak

    username: admin
    password: admin