# stage 1 : build archive
FROM maven:3.6.3-openjdk-11 as builder
WORKDIR /build

COPY pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY src src
RUN mvn package -Dmaven.test.skip=true

# stage 2 : packaging up for production
FROM bitnami/java:11-prod
WORKDIR /app

ENV JAVA_OPTS=""

COPY --from=builder /build/target/*.jar ./target/app.jar

ENV PORT=5000
EXPOSE $PORT

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dserver.port=${PORT} -jar ./target/app.jar" ]
