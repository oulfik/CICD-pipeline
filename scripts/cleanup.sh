#!/usr/bin/env sh
docker rm -f api
docker network disconnect -f test-net api
docker network rm test-net

