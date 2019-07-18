To set debug configuration with docker see screenshots directory.

### Debug with dockerfile
* noticed that breakpoints did not work until anything was read from standard input
* add a line that will delay a bit instructions execution, i.e.: `Thread.sleep(1000)`
* put break points after call of that line
* in the **IntelliJ**, in 'run configurations' select field pick 'remote debug test dockerfile', and **click debug**
* the app will proceed with instructions and will stop-wait on nearest breakpoint - voila we can debug


### Debug with docker-compose:
* noticed that breakpoints did not work until anything was read from standard input
* add a line that will delay a bit instructions execution, i.e.: `Thread.sleep(3000)` 
* put break points after call of that line
* in terminal launch `$ docker-compose up`
* in the **IntelliJ**, in 'run configurations' select field pick 'remote debug test docker-compose', and **click debug**
* the app will proceed with instructions and will stop-wait on nearest breakpoint - voila we can debug

### Docker-compose up and reading from standard input
* services behind docker-compose up are not attached to terminal, open new terminal and run:

`$ docker container attach IntellijDockerRemoteDebugTest`

you're now attached to this container's terminal, if it's the application is waiting for your prompt,
then just type and press enter
