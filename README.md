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

## How To Run
### Docker
docker-script.sh file takes care of compiling code and get the services up. and then you can access the eureka dashboard at
`http://localhost:1234/eureka-web`
```shell
./docker-script.sh
```