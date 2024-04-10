FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

ENV PROJECT_JAR=payments-VERSION.jar
ENV PROJECT_DIR=payments

RUN mkdir -p /home/app/${PROJECT_DIR}

COPY target/payments-VERSION.jar /home/app/${PROJECT_DIR}/${PROJECT_JAR}

WORKDIR /home/app/${PROJECT_DIR}
RUN chmod +x ${PROJECT_JAR}

ENV SPRING_PROFILES_ACTIVE=dev

CMD ["java", "-jar", "payments-VERSION.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]