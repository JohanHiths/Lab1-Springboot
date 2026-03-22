Experimenting with AOT

mvn clean package

java -XX:AOTCacheOutput=app.aot -Dspring.context.exit=onRefresh -jar .\target\Lab1Springboot-0.0.1-SNAPSHOT.jar

java -XX:AOTCache=app.aot -jar .\target\Lab1Springboot-0.0.1-SNAPSHOT.jar