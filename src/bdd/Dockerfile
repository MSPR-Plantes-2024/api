# Image de base postgres:alpine3.20
FROM postgres:alpine3.20

# Variables d'environnement
#ENV POSTGRES_DB=arosaje
ENV POSTGRES_USER=user
ENV POSTGRES_PASSWORD=Cascade23River
COPY arosaje_postgres_dump.sql /docker-entrypoint-initdb.d/init.sql

# Port exposé
EXPOSE 5432

#Lancer postgres
CMD ["postgres"]
