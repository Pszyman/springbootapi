FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/product.jar product.jar
ENTRYPOINT ["java","-jar","/product.jar"]

