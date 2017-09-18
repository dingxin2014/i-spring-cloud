# Dockerfile
FROM java:8u111-jdk
ADD demo-service-0.0.1-SNAPSHOT.jar /home
WORKDIR /home
ENTRYPOINT /home
CMD ["java", "-Xmx1024m", "-jar", "demo--0.0.1-SNAPSHOT.jar"]