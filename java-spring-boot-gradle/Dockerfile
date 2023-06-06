# Dont't use "latest" tag
ARG GRADLE_TAG=7.5-jdk18-alpine
ARG OPENJDK_TAG=18-alpine

# Build stage
FROM gradle:$GRADLE_TAG AS build

WORKDIR /app
COPY . .

RUN gradle build --no-daemon

# Package stage
FROM openjdk:$OPENJDK_TAG

WORKDIR /app

# Copy JAR
COPY --from=build /app/build/libs/api-0.0.0.jar ./application.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/application.jar"]
