Build:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle build`

Test:

`$ docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project -u "1000:1000" gradle:jdk11 gradle task test`

Run:
`$ java -jar build/libs/BankBranchCustomerApp.jar PL John 123.0 11.0 1.2`


Build docker image:
`$ docker image build -t bank-app .`

Run docker image:
`$ docker container run --rm bank-app [bank branch name] [customer name] [transactions...]`

Example:

`$ docker container run --rm bank-app PL John 11.0 12.4 16.1`
