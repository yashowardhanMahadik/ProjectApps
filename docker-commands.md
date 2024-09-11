docker run -it --rm -d -p 8080:80 --name webym nginx:1-alpine      // -it interactive --rm will delete the container -p is for port map
// -d is for detached mode
docker images	// for gettin images 
docker ps     // for containers gives port info also
docker inspect mongodb // for all info
docker stop webym // stop the temp container we started 
docker start webym3 	// once the container is already there

docker-compose up  // will start all the services cd to the directory in which your docker-compose.yml file is
docker-compose down // to stop the docker 
docker-compose start 	// will start the service mentioned after looking for it in the images
docker-compose stop 	// will stop the services 

/usr/share/nginx/html/
docker run -d -p 8088:80 -v ~/ymdocker:/usr/share/nginx/html/ --name webym nginx:1.27.0

docker build --platform linux/amd64 -t spring-helloworld .		//build springboot app after the dockerfile is already setup
docker-compose build	// directly build from the docker compose file
docker build --platform linux/amd64 -t trash-app .

docker-compose up --detach --build lb 	// in docker compose to restart the updated service "lb"- service name here
docker-compose up --detach --build service1	// rerun this its imp as the docker compose will use only cached
docker-compose up -d 

docker exec -it kafka /bin/sh
docker compose up -d
docker build -t kafkaconsumer .			// this is needed each time app is modified before running the docker compose, run in app folder only
docker-compose up --detach --build lb // then run this only in main folder it will recompile and redeploy connected apps only
