# microblog-app

Simple twitter-like micro-blogging platform.

## Features
* follow/unfollow other users
* post posts (the equivalent of tweets)
* post quotes (the equivalent of quote tweets)
* post response posts (the equivalent of twitter replies)
* like/unlike other users' posts
* tag posts
* mention other users in posts
* retrieve most popular tags in the last hour/day/week
* user's feed based on popularity/recency of posts
* notifications (when being quoted, responded to, or mentioned in another post)
* report posts
* search for users

## Dev Config

#### Cloning the repository 

The first step is to clone the repository and download the files that are contained in each submodule:

```
git clone https://github.com/Echelon133/microblog-app
cd microblog-app
git submodule init
git submodule update
```

#### Setting up passwords for two databases

A *.env* file has to be created in the main directory. It will contain passwords for both Redis and Neo4j databases.

```
REDIS_PASS = SOME_REDIS_PASSWORD
NEO4J_PASS= SOME_NEO4J_PASSWORD
```

Both *microblog-auth* and *microblog-backend* have an *application.properties* config file, which needs to contain both passwords from the *.env* file.

The config below has to appear in both *application.properties* files:
```
spring.data.neo4j.password=SOME_NEO4J_PASSWORD
spring.redis.password=SOME_REDIS_PASSWORD
```

#### Building docker images

To run the entire backend for the first time, *microblog-gateway*, *microblog-auth* and *microblog-backend* need to be built as docker images.

```
cd /microblog-gateway
./gradlew bootBuildImage --imageName=microblog-gateway

cd /microblog-auth
./gradlew bootBuildImage --imageName=microblog-auth

cd /microblog-backend
./gradlew bootBuildImage --imageName=microblog-backend
```

#### Running the backend of the application

After all these steps, executing **docker-compose up** in the main directory (the same which has a *docker-compose.yml* file) starts the entire backend of the application.

#### Running the dev version of the application's browser client for the first time

```
cd microblog-client/
npm install
npm run dev
```
