FROM openjdk:11-jdk

COPY ./src /usr/src/app/src
WORKDIR /usr/src/app/src

RUN javac IntellijDockerRemoteDebugTest.java
CMD java IntellijDockerRemoteDebugTest

#ENTRYPOINT ["./init.sh"]
#CMD ["java", "IntellijDockerRemoteDebugTest"]
