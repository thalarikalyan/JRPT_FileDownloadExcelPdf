FROM openjdk:17
EXPOSE 9635
WORKDIR appContainer
#Copy the jar from target to container
COPY ./target/springdocker.jar /appContainer
#Run the Java file
CMD ["java", "-jar","springdocker.jar"]
