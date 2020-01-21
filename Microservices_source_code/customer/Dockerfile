FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/customer.jar customer.jar
ENTRYPOINT ["java","-jar","/customer.jar"]

