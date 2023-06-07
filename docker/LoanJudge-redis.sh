docker network create docker_loanjudge

docker run --name loanjudge-redis \
-p 6379:6379 \
--network docker_loanjudge \
-d redis:latest
