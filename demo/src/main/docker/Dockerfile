# Dockerfile
FROM java:8u111-jdk
ADD demo-service-0.0.1-SNAPSHOT.jar /home
WORKDIR /home
ENTRYPOINT /home
CMD ["jar", "-Xmx1024m", "demo--0.0.1-SNAPSHOT.jar"]