FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

EXPOSE 8080

CMD ["java", "-jar", "build/libs/MarathonTagebuch-0.0.1-SNAPSHOT.jar"]