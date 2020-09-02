#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
docker rm -f app-pay
docker build -t ivancondori/app-pay:1.0 .
docker run -p 8006:8006 --name app-pay --network aforo255-test -d ivancondori/app-pay:1.0
echo ============================================================
echo End Process
echo ============================================================