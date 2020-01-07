FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/prison-management-system.jar prison-management-system.jar
ENTRYPOINT ["java","-jar","/prison-management-system.jar"]

