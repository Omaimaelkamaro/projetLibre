# Use a base image with JDK installed
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/GateWay-image.jar

# Expose the port that the microservice will use
EXPOSE 8081  # Change the port as per each microservice configuration

# Define the command to run the application
CMD ["java", "-jar", "GateWay-image.jar"]


