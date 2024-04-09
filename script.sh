#!bin/bash

#get all containers
docker ps -a

#to get services running
# Mandatory
docker-compose -f dev-ops/prerequisites/compose-db.yaml
docker-compose -f dev-ops/prerequisites/compose-broker.yaml up -d
# optional
docker-compose -f dev-ops/prerequisites/compose-jenkins.yaml up -d

#check logs
docker logs -f <container name>




