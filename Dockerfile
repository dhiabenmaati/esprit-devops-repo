FROM openjdk:11
EXPOSE 8089
ADD target/spring.jar spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]
