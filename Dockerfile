FROM gradle:7.5-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre-slim
EXPOSE 8081
COPY --from=build /home/gradle/src/build/libs/account-management-1.0.0.jar /app/
ENTRYPOINT ["java","-jar","/app/account-management-1.0.0.jar"]