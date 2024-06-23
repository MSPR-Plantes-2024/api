# Arosaje-API 
Arosaje-API est une api permettant de faire le lien avec les différentes applications front-end développés par notre équipe. 
Son objectif, est de permettre à un utilisateur de s'inscrire, se connecter et d'utiliser les fonctionnalités liés au gardiennage de plantes. 


## Prérequis

- [Docker](https://www.docker.com/) installé sur votre machine.

## Lancement de l'Api

1. Clonez le référentiel :

   ```bash
   git clone https://github.com/MSPR-Plantes-2024/api.git
   cd ./api
   
   ## Construction de la base de données 
   docker build -t arosaje-db-postgres .
   docker run -p 5432:5432 arosaje-db-postgres
   
   ## Construction de l'API
   docker build -t arosaje-api .
   docker run -p 8080:8080 arosaje-api
    

