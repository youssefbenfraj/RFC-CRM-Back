FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:11
EXPOSE 8075
ADD /target/CRM-0.0.1-SNAPSHOT.jar CRM-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CRM-0.0.1-SNAPSHOT.jar"]
