FROM jasch/openjdk8-javafx
MAINTAINER Sebastien Murgey <sebastien.murgey at rte-france.com>

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/powsybl/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/powsybl/gse-app.jar

RUN useradd -ms /bin/bash powsybl-gse
USER powsybl-gse
ADD target/docker-resources /home/powsybl-gse

WORKDIR /home/powsybl-gse

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/powsybl/gse-app.jar"]