# Utilisation de l'image eclipse-temurin:21-jre-alpine comme base
FROM eclipse-temurin:21-jdk-alpine

# Installation de git et Maven
RUN apk add --no-cache git maven

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Copy your source code
COPY src /app/src

# Copier le fichier .env
COPY .env .

# Construire le projet avec Maven
RUN mvn package -DskipTests

# Exposer le port sur lequel l'application s'exécutera
EXPOSE 8080

# Lancer l'application Spring Boot
# Retirer les variables d'environement dans un contexte de mise en production
CMD export DATABASE_PASSWORD = $POSTGRES_PASSWORD
CMD export DATABASE_USER = $POSTGRES_USER
CMD export DATABASE_URL = $DATABASE_URL

CMD source .env && mvn clean install exec:java
