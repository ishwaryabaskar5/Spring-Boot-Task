FROM openjdk:11

ADD ./target/muzix-0.0.1-SNAPSHOT.jar muzix-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","muzix-0.0.1-SNAPSHOT.jar"]