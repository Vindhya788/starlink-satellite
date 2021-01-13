FROM openjdk:8
VOLUME /tmp
EXPOSE 8089
ADD target/satellite-mysql.jar satellite-mysql.jar
ENTRYPOINT ["java", "-jar", "satellite-mysql.jar"]