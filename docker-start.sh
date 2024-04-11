#!/bin/bash

# get mandatory prerequisites up
cd dev-ops/prerequisites
docker compose -f compose-broker.yaml up -d
# get optional prerequisites up
#docker compose -f compose-db.yaml up -d
#docker compose -f compose-jenkins.yaml up -d
cd ../..

# get discovery server and api gateway up
cd dev-ops/compose
docker compose -f Eureka_ApiGate-compose.yaml --env-file dh.env up -d
# get services up
docker compose -f Service-compose.yaml --env-file dh.env up -d
cd ../..

# check if all images are running
docker ps

# check logs
# (only startup logs will be appear here, all the application logs are in /logs folder (except for third party images))
# docker logs -f <container name>

# debug in interactive mode
# docker exec -it <container name> /bin/bash
# check logs
# tail -f logs/<name>.log
# check is process is running
# jsp -l
#docker inspect -f '{{.NetworkSettings.Networks}}' container name