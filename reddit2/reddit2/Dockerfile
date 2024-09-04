FROM maven:3.9.8-eclipse-temurin-21 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/reddit2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","reddit2.jar"]