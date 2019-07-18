FROM openjdk:11-jdk

COPY ./src /usr/src/app/src
WORKDIR /usr/src/app/src

RUN javac $(find . -type f -name *.java)

# It's important to turn the java assertions ON
CMD java -ea pl.nstrefa.wojciechmocek.Test
