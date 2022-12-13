FROM openjdk:17-oracle
ADD target/tab-docker-test.jar tab-docker-test.jar
ENTRYPOINT ["java", "-jar", "/tab-docker-test.jar"]