# Charity Connect

## Стек

- Java 21
- Gradle Wrapper (`./gradlew`)
- Spring Boot
- PostgreSQL
- Redis
- Keycloak
- Docker / Docker Compose

## Структура проекта

```text
.
├── build-logic/                     # Included build с convention plugins
│   └── conventions/
├── common/
│   ├── common-core/                 # Общая Java-логика
│   └── common-spring/               # Общая Spring-логика
├── services/
│   └── user-service/                # REST сервис пользователей
├── docker/
│   ├── keycloak/realm.json
│   └── postgres/init.sql
├── docker-compose.yaml
├── settings.gradle.kts
└── build.gradle.kts
```

Gradle-проекты:

- `:common:common-core`
- `:common:common-spring`
- `:services:user-service`

## Быстрый старт

1. Собрать артефакты:

```bash
./gradlew clean build
```

2. Собрать Docker-образ(ы) сервисов через Jib:

```bash
./gradlew jibDockerBuildAll
```

3. Поднять инфраструктуру и сервисы:

```bash
docker compose up -d
```

4. Проверить состояние:

```bash
docker compose ps
```

5. Логи сервиса:

```bash
docker compose logs -f user-service
```

## Команды сборки образов (Jib)

- Для всех сервисов в локальный Docker daemon:

```bash
./gradlew jibDockerBuildAll
```

- Для всех сервисов с push в registry:

```bash
./gradlew jibAll
```

- Для одного сервиса:

```bash
./gradlew :services:user-service:jibDockerBuild
```

## Локальные URL

- `user-service`: http://localhost:8081
- Keycloak: http://localhost:8080
- Maihog: http://localhost:8025
- PostgreSQL: `localhost:5432`
- Redis: `localhost:6379`

## Credentials (dev)

- PostgreSQL:
  - username: `postgres`
  - password: `postgres`
- Keycloak admin:
  - username: `admin`
  - password: `admin`

## Полезные команды Gradle

```bash
./gradlew projects
./gradlew :services:user-service:tasks
./gradlew test
```

## Примечания

- Используйте `./gradlew`, а не системный `gradle`.
- Build logic подключен через `pluginManagement { includeBuild("build-logic") }`.
- Compose ожидает локальный образ `charity-connect/user-service:latest`, который создаётся задачей Jib.
