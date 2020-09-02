FROM openjdk:13
VOLUME "/tmp"
EXPOSE 8888
ADD ./target/pay-1.0.jar /pay.jar
ENTRYPOINT [ "java","-jar","/pay.jar" ]