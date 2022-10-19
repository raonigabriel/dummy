FROM ghcr.io/raonigabriel/coder-core:latest

# Install the tools required by wait-for
RUN sudo apk add --no-cache curl wget netcat-openbsd

# Install newman (Postman CLI)
RUN sudo npm install -g newman newman-reporter-htmlextra

COPY ./postman /postman
COPY ./checks.sh /checks.sh
COPY ./wait-for /bin/wait-for

CMD ["/bin/wait-for", "http://app:8080/cities", "-t", "300", "--", "/checks.sh"]
