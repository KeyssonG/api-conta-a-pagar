# Use uma imagem base do Maven para compilar o projeto
FROM maven:3.9.4-eclipse-temurin AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/api-conta-pagar-*.jar app.jar

# Define o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
