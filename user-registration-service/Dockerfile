FROM  openjdk:11-jdk-stretch
WORKDIR /i2ps/user

ADD target/user-registration-service-0.0.1-SNAPSHOT.jar /i2ps/user/user-registration-service-0.0.1-SNAPSHOT.jar



ENTRYPOINT  ["java","-jar","user-registration-service-0.0.1-SNAPSHOT.jar"]