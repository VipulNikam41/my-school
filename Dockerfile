FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

RUN mkdir -p /home/app

COPY target/MySchool.jar /home/app/MySchool.jar

WORKDIR /home/app

ENV SPRING_PROFILES_ACTIVE=dev

CMD ["java", "-jar", "/home/app/MySchool.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]