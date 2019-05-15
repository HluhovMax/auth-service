FROM openjdk:8
ADD target/auth-service-0.0.1-SNAPSHOT.jar auth-service-0.0.1-SNAPSHOT
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "auth-service-0.0.1-SNAPSHOT"]
