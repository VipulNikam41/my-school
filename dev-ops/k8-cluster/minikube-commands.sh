#!/bin/bash

# reset all
minikube delete --all

# start minikube cluster
minikube start --driver qemu --network socket_vmnet

kubectl get all

minikube service <service-name>


## ingress config
minikube addons enable ingress
kubectl apply -f ingress-school.yaml
kubectl get ingress
sudo vi /etc/hosts # add name to this file with ingress ip->


## debug
kubectl exec -it <pod> /bin/bash # apparently deprecated
kubectl logs <pod>
kubectl logs -f <pod> # follow logs
tail -f file.log

jar -xf <app.jar> # to un-jar a jar
