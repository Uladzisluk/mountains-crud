FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="mountains-peak"
LABEL org.opencontainers.image.authors="Uladzislau Lukashevich"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple application created using spring and angular frameworks"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""
ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-character
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/mountains-peak-${VERSION}.jar /opt/mountains-peak/mountains-peak.jar

CMD ["java", "-jar", "/opt/mountains-peak/mountains-peak.jar"]
