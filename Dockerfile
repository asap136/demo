FROM openjdk:8-jdk-alpine
ADD build/libs/demo-1.0.0-SNAPSHOT.jar /app/application.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/application.jar"]