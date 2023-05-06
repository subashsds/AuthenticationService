# Maven build container 
FROM openjdk:8-jre-alpine

COPY target/authentication-Service-0.0.1-SNAPSHOT.jar authentication-Service.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/authentication-Service.jar"]