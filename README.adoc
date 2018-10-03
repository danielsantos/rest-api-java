# Rest API Java

Rest API Example - Java | Spring Boot | Rest

## Getting Started

To Build and Run:
```
$ mvn spring-boot:run
```

## Database

Para usar o banco do MySQL é necessário descomentar as linhas abaixo no arquivo application.properties;
Se não banco em memória H2 será usado para persistir os dados que se encontram no arquivo data.sql

```
spring.datasource.url=jdbc:mysql://localhost:3306/books
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

### H2

For view console dabatase H2 embedded, with the application up, access the url bellow:

http://localhost:8080/h2-console
