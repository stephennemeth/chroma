FROM openjdk:23-slim
WORKDIR /app
COPY /target/*.jar /app/chroma.jar
EXPOSE 8080
CMD ["java", "-jar", "chroma.jar"]