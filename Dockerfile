# Step 1: Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the jar file from target folder to the container
COPY target/taskproject-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
