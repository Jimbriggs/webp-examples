#!/bin/sh
mvn clean package && docker build -t jim/jpa2021first .
docker rm -f jpa2021first || true && docker run -d -p 9080:9080 -p 9443:9443 --name jpa2021first jim/jpa2021first