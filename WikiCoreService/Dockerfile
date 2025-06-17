# Stage 1: Сборка проекта
FROM gradle:8.5.0-jdk21 as builder
WORKDIR /app
COPY . .
RUN ./gradlew :WikiCoreService:build --no-daemon -x test

# Stage 2: Запуск приложения
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/WikiCoreService/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]