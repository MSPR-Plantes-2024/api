# Image de base postgres:alpine3.20
FROM postgres:alpine3.20

# Variables d'environnement
COPY arosaje_postgres_dump.sql /docker-entrypoint-initdb.d/init.sql

# Port exposé
EXPOSE 5432

#Lancer postgres
CMD ["docker-entrypoint.sh", "postgres"]
