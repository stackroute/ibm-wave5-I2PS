FROM openjdk:11-jdk-stretch

WORKDIR /src/main/i2ps

ADD ./target/spring-neo4j-example-0.0.1-SNAPSHOT.jar   /src/main/i2ps/spring-neo4j-example-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","spring-neo4j-example-0.0.1-SNAPSHOT.jar"]