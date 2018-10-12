FROM gradle:4.10-jdk8-alpine as builder
COPY --chown=gradle . /project/
WORKDIR /project/
RUN gradle build --configure-on-demand

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=builder /project/build/libs/api-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]