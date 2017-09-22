# Dockerfile
FROM java:8u111-jdk
MAINTAINER Douglas.Ding <being_away@qq.com>
ARG JAR
ENV JAR ${JAR}
USER root
RUN cd /
RUN mkdir tomcat
ADD build/libs /tomcat/
RUN chmod -R 777 tomcat/
WORKDIR /tomcat
#ENTRYPOINT ["tomcat"]
CMD java -Xmx1024m -jar /tomcat/${JAR}.jar

