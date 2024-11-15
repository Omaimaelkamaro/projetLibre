# Démarrer à partir d'une image Java de base
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR construit par Maven dans le conteneur
COPY ./target/userAuthentification-0.0.1-SNAPSHOT.jar /app/userAuthentification-image.jar


# Exposer le port que le microservice utilisera
EXPOSE 9898

# Définir la commande pour exécuter le fichier JAR
ENTRYPOINT ["java", "-jar", "/app/userAuthentification-image.jar"]
