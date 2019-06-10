Prerequisites: java 11+ 

You may build it and run using gradle.

Examples:

`./gradlew build && ./gradlew run`

Also you may use Docker to build, i.e.:

`docker container run --rm -t -v "$PWD":/home/gradle/project -w /home/gradle/project -v gradle-cache:/home/gradle/.gradle -u gradle gradle:jdk11 gradle build`

And to run:
`java -jar build/libs/sportleague.jar`

Or run using docker:
`docker container run --rm -t -v "$PWD/build/libs/sportleague.jar":/usr/app/app.jar -w /usr/app openjdk:11-jre java -jar app.jar`