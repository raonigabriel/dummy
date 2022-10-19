FROM ghcr.io/raonigabriel/coder-core:latest as common

RUN sudo apk --no-cache add openjdk17-jre-headless

####################################################################
FROM common as builder

ENV JAVA_HOME=/usr/lib/jvm/default-jvm \
    MAVEN_HOME=/usr/share/java/maven-3

RUN sudo apk --no-cache add maven

COPY --chown=coder:coder . /tmp
WORKDIR /tmp
RUN mvn clean -ntp package

####################################################################
FROM common as output

COPY --chown=coder:coder --from=builder /tmp/target/dummy-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
