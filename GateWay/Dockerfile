# Démarrer à partir d'une image Java de base
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR construit par Maven dans le conteneur
COPY ./GateWay/target/GateWay-image.jar /app/GateWay-image.jar

# Exposer le port que le microservice utilisera
EXPOSE 8080

# Définir la commande pour exécuter le fichier JAR
ENTRYPOINT ["java", "-jar", "/app/GateWay-image.jar"]
