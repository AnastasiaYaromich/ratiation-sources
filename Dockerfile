FROM jenkins/jenkins

USER 0

ARG DOCKERGID=998

# Docker
RUN apt-get update \
    && apt-get install software-properties-common apt-transport-https ca-certificates gnupg-agent dialog apt-utils -y \
    && curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - \
    && add-apt-repository \
        "deb [arch=amd64] https://download.docker.com/linux/debian \
        $(lsb_release -cs) \
        stable" \
    && apt-get update \
    && apt-get install docker-ce-cli -y

# Setup users and groups
RUN addgroup --gid ${DOCKERGID} docker
RUN usermod -aG docker jenkins



FROM openjdk:17-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/ratiation-sources-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



