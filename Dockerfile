# Use the official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Install curl (if it's not already installed)
RUN apt-get update && apt-get install -y curl

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY /build/libs/yob-thirdparty-api-service-0.0.1-SNAPSHOT.jar main.jar

# Download the OpenTelemetry Java agent directly into the container using curl
RUN curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar -o /app/opentelemetry-javaagent.jar

# Set the environment variable for the Java agent
ENV JAVA_TOOL_OPTIONS="-javaagent:./app/opentelemetry-javaagent.jar"

# Run the Spring Boot application with the OpenTelemetry Java agent
CMD ["java", "-jar", "main.jar"]
