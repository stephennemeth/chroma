#!/bin/bash

mvn package -DskipTests
docker build -f Dockerfile.dockerfile -t chroma-backend .