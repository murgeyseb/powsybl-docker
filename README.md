# Powsybl GSE Docker

## Work in progress
This source is under developement and is not currently effective for using WS implementation of AFS in GSE.

## Overview
This is a test of creation of a docker based deployments of Powsybl GSE platform into docker containers based on SpringBoot
for web-service deployment.

## Environment requirements
In order to build the project, you need:
  * JDK *(1.8 or greater)*
  * Maven
  * Powsybl (snapshot version)
  * Powsybl GSE (snapshots version)
  * Docker
  * Docker-compose

## Install
To compile and generate Docker images, you just have to use:
```
$> mvn clean package
```

## Using the platform
Launch the AFS server:
```
$> docker-compose up afs-server
```

Then when it has started, launch GSE:
```
$> docker-compose up gse-app
```

To stop the services:
```
$> docker-compose down
```
