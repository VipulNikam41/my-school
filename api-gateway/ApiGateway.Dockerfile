FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

ENV PROJECT_JAR=api-gateway-VERSION.jar
ARG PROJECT_DIR=api-gateway

RUN mkdir -p /home/app/${PROJECT_DIR}

COPY target/api-gateway-VERSION.jar /home/app/${PROJECT_DIR}/${PROJECT_JAR}

WORKDIR /home/app/${PROJECT_DIR}
RUN chmod +x ${PROJECT_JAR}

CMD ["java", "-jar", "api-gateway-VERSION.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]