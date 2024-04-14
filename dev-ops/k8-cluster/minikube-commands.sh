#!/bin/bash

# reset all
minikube delete --all

# start minikube cluster
minikube start --driver qemu --network socket_vmnet

kubectl get all

minikube service <service-name>

jar -xf <app.jar> # to unjar a jar