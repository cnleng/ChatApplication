# Stage 1: Build the application
FROM gradle:jdk17 AS build

WORKDIR /app

# Copy Gradle files
COPY build.gradle settings.gradle /app/
#COPY gradle /app/gradle

# Copy application source code
COPY src /app/src

# Build the application
RUN gradle clean build --no-daemon

# Stage 2: Create production image
FROM openjdk:17-jdk

WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/build/libs/chat-services-0.0.1.jar /app/chat-services.jar

EXPOSE 8080
# Set the startup command for the Spring Boot application
CMD ["java", "-jar", "chat-services.jar"]
