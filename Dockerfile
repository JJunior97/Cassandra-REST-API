
FROM openjdk:8
ADD target/api.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
