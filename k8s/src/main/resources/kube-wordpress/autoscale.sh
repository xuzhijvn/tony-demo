#!/bin/bash
kubectl autoscale deployment wordpress --namespace kube-example --cpu-percent=20 --min=3 --max=6