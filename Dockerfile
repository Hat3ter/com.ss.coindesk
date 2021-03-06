FROM openjdk:11-jre-slim
WORKDIR /app
COPY /app/build/libs/app.jar ./app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]