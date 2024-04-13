#!/bin/bash
######## clean up ########

function stop_container {
    docker stop payments management-ops syllabus-hub
    docker stop api-gateway discovery-server
    docker stop redis broker zookeeper
    echo "containers stopped."
}

function remove_container {
    docker rm payments management-ops syllabus-hub
    docker rm api-gateway discovery-server
    docker rm redis broker zookeeper
    echo "containers removed."
}

function remove_images {
    docker rmi payments management-ops syllabus-hub
    docker rmi api-gateway discovery-server
#    docker rmi redis:7.2.4 confluentinc/cp-kafka:7.0.1 confluentinc/cp-zookeeper:7.0.1
    echo "images removed."
}

if [ $# -eq 0 ] || [ "$1" = "stop" ]; then
    stop_container
elif [ "$1" = "rm" ]; then
    stop_container
    remove_container
elif [ "$1" = "rmi" ]; then
    stop_container
    remove_container
    remove_images
else
    echo "Invalid argument. Please provide stop, rm or rmi."
    exit 1
fi