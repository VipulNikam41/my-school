# Versions
### Java
Java 17 is used to compile give code. (Find below exact datails)
```shell
$ java --version
openjdk 17.0.9 2023-10-17 LTS
OpenJDK Runtime Environment Corretto-17.0.9.8.1 (build 17.0.9+8-LTS)
OpenJDK 64-Bit Server VM Corretto-17.0.9.8.1 (build 17.0.9+8-LTS, mixed mode, sharing)
```
### Postgresql
```shell
$ psql --version
psql (PostgreSQL) 15.4
```
### Maven
```shell
$ mvn --version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /usr/share/maven
Java version: 17.0.9, vendor: Amazon.com Inc., runtime: /usr/lib/jvm/java-17-amazon-corretto.x86_64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.1.59-84.139.amzn2023.x86_64", arch: "amd64", family: "unix"
```
### Docker
```shell
$ docker --version
Docker version 24.0.5, build ced0996
```
### Jenkins
given jenkins file `deploy/Jenkinsfile` requires `maven` and `docker` both installed in machine where jenkins is running.
```shell
$ jenkins --version
2.414.3
```
Adding maven to tools wont work as tool section not defined in JenkinsFile. Add below snippet to jenkins file if mvn not installed on machine.
```groovy
tools {
    maven 'YourMavenNameFromTools'
}
```

# Installation Guide

### Maven
```shell
curl -fsSL -o /tmp/apache-maven.tar.gz https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.6.3/apache-maven-3.6.3-bin.tar.gz
cd /usr/share && mkdir maven
tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1
rm -f /tmp/apache-maven.tar.gz
ln -s <or> -sf /usr/share/maven/bin/mvn /usr/bin/mvn
```

### Dokcer
```shell
curl https://get.docker.com/ > dockerinstall && chmod 777 dockerinstall && ./dockerinstall
```
### AWS CLI 
```shell
curl https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip
unzip awscliv2.zip
./aws/install
```