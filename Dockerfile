FROM openjdk:17-alpine
WORKDIR /app
COPY ./build/libs/*-SNAPSHOT.jar /app/app.jar
CMD [ "java", "-jar", "/app/app.jar"]
