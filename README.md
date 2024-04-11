# MySchool

## How To Run

### Docker
docker-script.sh file takes care of compiling code and get the services up. once all containers runnign, wait for 30 seconds for all containers to register with eureka and fetch the latest registry. Then you can access the eureka dashboard at
`http://localhost:1234/eureka-web`
```shell
./docker-start.sh
```

for cleanup go to bottom of `docker-script.sh`, uncomment and copy cleanup script and run it to stop, remove container and delete images

### local
Use java Amazon Corretto 17 and maven 3.6.3 to run the below program locally
```shell
mvn clean install
java -jar <path/to/application.jar> --spring.profiles.active=<profiles>
```
To change version
```shell
mvn versions:set -DnewVersion=<version>
```