FROM openjdk:17-jdk-slim
RUN mkdir -p /apps/sqlite
ADD src/main/resources/sample.db /apps/sqlite
VOLUME /tmp
ADD target/jumia-backend-0.0.1.jar  app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-DSQLITEDB_PATH=/apps/sqlite/sample.db","-jar","/app.jar"]
