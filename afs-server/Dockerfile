FROM openjdk:8-jre
MAINTAINER Sebastien Murgey <sebastien.murgey at rte-france.com>

EXPOSE 8080

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib /usr/share/powsybl/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/powsybl/afs-server.jar

RUN useradd -ms /bin/bash powsybl-afs
USER powsybl-afs
ADD target/docker-resources /home/powsybl-afs

WORKDIR /home/powsybl-afs

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/powsybl/afs-server.jar"]