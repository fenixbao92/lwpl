jps | grep lwpl-backend | awk '{print $1}' | xargs kill -9
cd ./lwpl-backend
mvn install
nohup java -jar ./target/lwpl-backend-1.0-SNAPSHOT.jar &