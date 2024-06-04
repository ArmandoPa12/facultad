    # Usa una imagen base de Java 11
FROM openjdk:20

WORKDIR /app

# Copia el JAR de tu aplicación Spring Boot al contenedor
COPY target/facultad-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto 8080 para que la aplicación sea accesible
EXPOSE 8090

# Comando para ejecutar la aplicación Spring Boot cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]