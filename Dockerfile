FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

RUN mkdir -p /home/app

COPY target/MySchool.jar /home/app/MySchool.jar

WORKDIR /home/app

CMD ["java", "-jar", "target/MySchool.jar"]