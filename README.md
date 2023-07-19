# cache-example-with-log-file
full implementation of caching with spring boot and log file

Note: make sure your Redis server is up and running. For this project, I ran the server on docker :
Use the syntax below to run the image and use the localhost:8001 as a port to access the redis-ui . Make sure docker is running on your system 
 docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest

# redis configuration
spring.data.redis.host=localhost
spring.data.redis.port=6379

spring.cache.cache-names[0]=cache1
spring.cache.cache-names[1]=cache2
spring.cache.redis.cache-null-values=true
spring.cache.type=redis
spring.cache.redis.time-to-live=60000

# docker pom file.
# add this into the plug-in.

                <configuration>
                    <image>
                        <name>09/2022-v1caching-${project.artifactId}:${project.version}</name>
                    </image>
                </configuration> 

# redis requirements

       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
