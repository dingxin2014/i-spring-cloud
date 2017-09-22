# Dockerfile
FROM java:8u111-jdk
USER root
RUN cd /
RUN mkdir tomcat
ADD build/libs /tomcat/
RUN chmod -R 777 tomcat/
WORKDIR /tomcat
#ENTRYPOINT ["tomcat"]
CMD ["java", "-Xmx1024m", "-jar", "/tomcat/demo-service-0.0.1-SNAPSHOT.jar"]