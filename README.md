# Arosaje-API 
Arosaje-API est une api permettant de faire le lien avec les différentes applications front-end développés par notre équipe. 
Son objectif, est de permettre à un utilisateur de s'inscrire, se connecter et d'utiliser les fonctionnalités liés au gardiennage de plantes. 


## Prérequis

- [Docker](https://www.docker.com/) installé sur votre machine.

## Installation

1. Clonez le référentiel :

   ```bash
   git clone https://github.com/votre-utilisateur/votre-projet.git
   cd votre-projet
   docker build . -t arosaje:latest 
   docker run arosaje -p 8080
