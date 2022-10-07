FROM alpine:3.11.2
RUN apk add --no-cache openjdk11
COPY build/libs/clients-register-ms-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/clients-register-ms-1.0-SNAPSHOT.jar"]
