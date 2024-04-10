FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

ENV PROJECT_JAR=discovery-server-VERSION.jar
ARG PROJECT_DIR=discovery-server

RUN mkdir -p /home/app/${PROJECT_DIR}

COPY target/discovery-server-VERSION.jar /home/app/${PROJECT_DIR}/${PROJECT_JAR}

WORKDIR /home/app/${PROJECT_DIR}
RUN chmod +x ${PROJECT_JAR}

ENV SPRING_PROFILES_ACTIVE=dev

CMD ["java", "-jar", "discovery-server-VERSION.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]