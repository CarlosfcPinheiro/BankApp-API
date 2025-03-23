FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests -U

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/api-rest-springboot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]