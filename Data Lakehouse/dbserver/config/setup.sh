#!/bin/sh

# https://stackoverflow.com/questions/46482257/how-to-add-a-startup-script-to-a-mysql-docker-container
# https://stackoverflow.com/questions/38504257/mysql-scripts-in-docker-entrypoint-initdb-are-not-executed

# wait for initilization
echo "waiting mysql to initialize"
sleep 10

echo "creating database"
mysql -u root -p'password' < /mysql/northwind.sql
mysql -u root -p'password' < /mysql/northwind-data.sql
echo "database created"