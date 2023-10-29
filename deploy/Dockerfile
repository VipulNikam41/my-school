FROM amazoncorretto:17 AS build

ARG MAVEN_VERSION=3.6.3

ENV MAVEN_HOME /usr/share/maven
ENV USER_HOME_DIR /root
ENV MAVEN_URL https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${MAVEN_VERSION}/apache-maven-${MAVEN_VERSION}-bin.tar.gz
ENV DB_USERNAME=root
ENV DB_PASSWORD=1234

RUN yum install -y curl tar
RUN yum install -y gzip

RUN mkdir -p ${MAVEN_HOME} /usr/share/maven/ref
RUN curl -fsSL -o /tmp/apache-maven.tar.gz ${MAVEN_URL}
RUN tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1
RUN rm -f /tmp/apache-maven.tar.gz
RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

RUN mkdir -p /home/app

COPY ../src /home/app/src
COPY ../pom.xml /home/app/
COPY ../flyway.conf /home/app/

WORKDIR /home/app

RUN mvn clean install
RUN mvn flyway:migrate

WORKDIR /home/app

CMD ["java", "-jar", "target/MySchool.jar"]