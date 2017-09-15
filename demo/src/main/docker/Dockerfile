FROM java:7
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
CMD ["jar", "-Xmx1024m", "dev-zhaopin.war"]

entrypotint /var/workspace