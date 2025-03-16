FROM mysql:latest
USER mysql

COPY mywind-master/*.sql /mysql/
COPY config/setup.sh /mysql/
COPY config/run-bg.sh /docker-entrypoint-initdb.d