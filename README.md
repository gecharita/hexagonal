# DDD: Hexagonal Architecture Example

```sh
docker run -p 9099:3306 --name mysql-anemic-demo -e MYSQL_ROOT_PASSWORD=admin -d mysql:latest
docker exec -it mysql-anemic-demo bash
mysql -u root -p
CREATE DATABASE anemic;
```
