FROM openjdk:8
ADD target/backend-mysql.jar backend-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","backend-mysql.jar"]