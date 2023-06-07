docker run -d \
--name loanjudge-mysql \
-e MYSQL_ROOT_PASSWORD="password" \
-e MYSQL_USER="loanjudge" \
-e MYSQL_PASSWORD="test" \
-e MYSQL_DATABASE="loanjudge" \
-p 3307:3307 \
--network docker_loanjudge mysql:latest
