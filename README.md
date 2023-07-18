# cache-example-with-log-file
full implementation of caching with spring boot and log file

Note: make sure your Redis server is up and running. For this project, I ran the server on docker :
Use the syntax below to run the image and use the localhost:8001 as a port to access the redis-ui . Make sure docker is running on your system 
 docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest
