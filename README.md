# MySchool
run java program
```shell
mvn clean install
java -jar <path/to/application.jar> --spring.profiles.active=<profiles>
```
run docker compose file in deploy folder
```shell
docker compose --env-file dev.env up
```
to change version
```shell
mvn versions:set -DnewVersion=<version>
```