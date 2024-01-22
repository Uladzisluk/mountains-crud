FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="mountains-range"
LABEL org.opencontainers.image.authors="Uladzislau Lukashevich"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple application created using spring and angular frameworks"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-user
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV MOUNTAINS_PEAK_URL=http://localhost:8081

EXPOSE 8080

COPY target/mountains-range-${VERSION}.jar /opt/mountains-range/mountains-range.jar

CMD ["java", "-jar", "/opt/mountains-range/mountains-range.jar"]
