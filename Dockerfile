# Start with a base image containing Java runtime
#FROM openjdk:8-jdk-alpine
FROM openjdk:11-jre-slim

# Add Maintainer Info
# MAINTAINER 

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/API-Dummy-1.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} api-dummy.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/api-dummy.jar"]