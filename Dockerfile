FROM centos:7

RUN yum install -y \
       java-1.8.0-openjdk \
       java-1.8.0-openjdk-devel

ENV JAVA_HOME /etc/alternatives/jre

COPY target/user-service-1.0-SNAPSHOT.jar /app/user-svc.jar

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app/user-svc.jar"]