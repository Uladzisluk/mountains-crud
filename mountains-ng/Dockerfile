FROM node:latest as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:1.23.3

LABEL org.opencontainers.image.title="mountains-ng"
LABEL org.opencontainers.image.authors="Uladzislau Lukashevich"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple application created using spring and angular frameworks"
LABEL org.opencontainers.image.licenses="MIT"

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL=http://localhost:8080/api

COPY --from=build /app/dist/mountains-ng/browser  /usr/share/nginx/html
COPY docker/etc/nginx/conf.d/nginx.conf /etc/nginx/conf.d/default.template

EXPOSE 80
