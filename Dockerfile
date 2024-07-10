FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/binance-connector.jar app.jar

CMD ["java", "-jar", "app.jar"]