# Start from a base Java image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/GateWay-image.jar /app/GateWay-image.jar


# Expose the port that the microservice will use
EXPOSE 8080

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/GateWay-image.jar"]
