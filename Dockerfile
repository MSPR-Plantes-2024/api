# Utilisation de l'image eclipse-temurin:21-jre-alpine comme base
FROM eclipse-temurin:21-jdk-alpine

# Installation de git et Maven
RUN apk add --no-cache git maven

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Cloner le dépôt GitHub
RUN git clone https://github.com/MSPR-Plantes-2024/api.git .
RUN git pull origin main

# Construire le projet avec Maven
RUN mvn package -DskipTests

# Exposer le port sur lequel l'application s'exécutera
EXPOSE 8080

# Lancer l'application Spring Boot
CMD mvn clean compile exec:java
