#use java 21 lightweight linux image
FROM eclipse-temurin:21-jdk-alpine

#create woking folder inside container
WORKDIR /app

#copy Spring Boot WAr file into container
COPY target/*.war app.war

#docker app uses port 8080
EXPOSE 8080

#run spring boot app
ENTRYPOINT ["java", "-jar", "app.war"]