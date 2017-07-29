FROM java:8
EXPOSE 8080
ADD /target/springBootMs.jar springBootMs.jar
ENTRYPOINT ["java", "-jar", "springBootMs.jar"]


