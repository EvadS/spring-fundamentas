FROM tomcat:8-jdk11

LABEL maintainer="evad-se@mail.ru"

ADD target/sample.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]