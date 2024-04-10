#!/bin/bash

# compile whole code
mvn clean install

# build images of each service
cd api-gateway
docker build -t api-gateway --file ApiGateway.Dockerfile .
cd ../discovery-server
docker build -t discovery-server --file DiscoveryServer.Dockerfile .
cd ../manage-ops
docker build -t manage-ops --file ManageOps.Dockerfile .
cd ../payments
docker build -t payments --file Payments.Dockerfile .
cd ../syllabus-hub
docker build -t syllabus-hub --file SyllabusHub.Dockerfile .
cd ..

# check if all image build was success
docker images

# get mandatory prerequisites up
cd dev-ops/prerequisites
docker compose -f compose-broker.yaml up -d
# get optional prerequisites up
#docker compose -f compose-db.yaml up -d
#docker compose -f compose-jenkins.yaml up -d
cd ../..

# get discovery server and api gateway up
cd dev-ops/compose
docker compose -f Eureka_ApiGate-compose.yaml up -d
# get services up
docker compose -f Service-compose.yaml up -d
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


######## clean up ########

## stop container
#docker stop payments manage-ops syllabus-hub
#docker stop api-gateway discovery-server
#docker stop broker zookeeper

## remove container
#docker rm payments manage-ops syllabus-hub
#docker rm api-gateway discovery-server
#docker rm broker zookeeper

## remove images
#docker rmi payments manage-ops syllabus-hub
#docker rmi api-gateway discovery-server
#docker rmi confluentinc/cp-kafka:7.0.1 confluentinc/cp-zookeeper:7.0.1