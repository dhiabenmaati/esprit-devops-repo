FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]
EXPOSE 8089
