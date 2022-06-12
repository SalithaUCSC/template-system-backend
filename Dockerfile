FROM openjdk:8
ADD target/template-system-backend.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]