FROM gradle:jdk11 as builder
USER root
COPY . /home/gradle/project
WORKDIR /home/gradle/project

RUN gradle build

FROM openjdk:11-jre
COPY --from=builder  /home/gradle/project/build/libs/BankBranchCustomerApp.jar /app/BankBranchCustomerApp.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/app/BankBranchCustomerApp.jar"]
