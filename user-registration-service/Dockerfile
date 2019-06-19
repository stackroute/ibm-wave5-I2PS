FROM  openjdk:11-jdk-stretch
WORKDIR /i2ps/user

ADD target/userservice-0.0.1-SNAPSHOT.jar /i2ps/user/userservice-0.0.1-SNAPSHOT.jar



ENTRYPOINT  ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]