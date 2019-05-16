Build:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle build`

Test:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle task test`