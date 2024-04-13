FROM openjdk:21

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
# docker build -t apigateway-dockerfile .