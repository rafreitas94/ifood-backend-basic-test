FROM openjdk

WORKDIR /app

COPY /target/demo-0.0.1-SNAPSHOT.jar /app/ifood-backend-basic-test.jar

ENTRYPOINT ["java", "-jar", "ifood-backend-basic-test.jar"]