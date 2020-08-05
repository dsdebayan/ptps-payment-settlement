FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8002
ADD target/payment-settlement.jar app2.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app2.jar" ]