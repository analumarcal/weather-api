# Use a imagem base do Maven
FROM maven:3.8.5-openjdk-17 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e as dependências
COPY pom.xml .
COPY src ./src

# Execute o Maven para compilar a aplicação
RUN mvn clean package -DskipTests

# Use a imagem base do OpenJDK para o runtime
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da etapa de construção
COPY --from=build /app/target/weather-api-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

