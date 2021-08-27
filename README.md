# MyTictactoe

## Requirements

For building and running the application you need:

- [JDK 11]
- [Maven](https://maven.apache.org)

## Running the application locally

You can run the application like this:     
Place in the root folder and execute :
```shell
mvnw spring-boot:run
```


routes exposed 

```shell
http://localhost:8080/tictactoe/start
http://localhost:8080/tictactoe/move?row=2&col=1
```
start route => to start a new game     
move route => to place X or O in the position    
