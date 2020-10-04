FROM openjdk:8
COPY /target/assignment-backend.jar assignment-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","assignment-backend.jar"]