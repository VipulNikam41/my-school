#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: $0 <argument>"
    exit 1
fi

cd ../../
mvn clean install

cd api-gateway
docker build -t api-gateway --file ApiGateway.Dockerfile .
docker tag api-gateway vipuldoger/api-gateway:"$1"
docker push vipuldoger/api-gateway:"$1"

cd ../discovery-server
docker build -t discovery-server --file DiscoveryServer.Dockerfile .
docker tag discovery-server vipuldoger/discovery-server:"$1"
docker push vipuldoger/discovery-server:"$1"

cd ../manage-ops
docker build -t manage-ops --file ManageOps.Dockerfile .
docker tag manage-ops vipuldoger/manage-ops:"$1"
docker push vipuldoger/manage-ops:"$1"

cd ../payments
docker build -t payments --file Payments.Dockerfile .
docker tag payments vipuldoger/payments:"$1"
docker push vipuldoger/payments:"$1"

cd ../syllabus-hub
docker build -t syllabus-hub --file SyllabusHub.Dockerfile .
docker tag syllabus-hub vipuldoger/syllabus-hub:"$1"
docker push vipuldoger/syllabus-hub:"$1"

cd ..
