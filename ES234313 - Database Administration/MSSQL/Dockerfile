FROM mcr.microsoft.com/mssql/server:2022-latest
USER root

# Create a config directory
RUN mkdir -p /usr/config
WORKDIR /usr/config

# Bundle MSSQL Backup (download it)
COPY data/*.bak /usr/config

# Bundle config source
COPY config/*.sh /usr/config
COPY config/*.sql /usr/config

# Grant permissions for to our scripts to be executable
RUN chmod 777 /usr/config/entrypoint.sh
RUN chmod 777 /usr/config/configure-db.sh

ENTRYPOINT ["./entrypoint.sh"]