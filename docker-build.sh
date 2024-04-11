#!/bin/bash

mvn clean install

cd api-gateway
docker build -t api-gateway:new --file ApiGateway.Dockerfile .

cd ../discovery-server
docker build -t discovery-server:new --file DiscoveryServer.Dockerfile .

cd ../manage-ops
docker build -t manage-ops:new --file ManageOps.Dockerfile .

cd ../payments
docker build -t payments:new --file Payments.Dockerfile .

cd ../syllabus-hub
docker build -t syllabus-hub:new --file SyllabusHub.Dockerfile .

cd ..

if [ $# -ne 1 ]; then
    echo "Usage: $0 <argument>"
    exit 1
fi

docker tag api-gateway:new vipuldoger/api-gateway:"$1"
docker push vipuldoger/api-gateway:"$1"

docker tag discovery-server:new vipuldoger/discovery-server:"$1"
docker push vipuldoger/discovery-server:"$1"

docker tag manage-ops:new vipuldoger/manage-ops:"$1"
docker push vipuldoger/manage-ops:"$1"

docker tag payments:new vipuldoger/payments:"$1"
docker push vipuldoger/payments:"$1"

docker tag syllabus-hub:new vipuldoger/syllabus-hub:"$1"
docker push vipuldoger/syllabus-hub:"$1"