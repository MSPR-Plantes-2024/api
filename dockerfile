FROM openjdk:21-jdk-slim-bookworm
COPY ./target /app
WORKDIR /app
RUN mkdir -p src/bdd
RUN touch src/bdd/arosaje.bd
RUN mv *.jar app.jar
ARG JAR_FILE=/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
