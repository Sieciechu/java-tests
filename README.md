Build:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle build`

Test:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle task test`

Run:
`$ java -jar build/libs/BankBranchCustomerApp.jar`


Build docker image:
`$ docker image build -t bank-app .`

Run docker image:
`$ docker container run --rm bank-app`

Example:

`$ docker container run --rm bank-app`
