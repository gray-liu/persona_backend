From openjdk:11.0.9-jdk
VOLUME /tmp
ADD target/persona_backend.jar persona_backend.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /persona_backend.jar