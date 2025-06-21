# Urls

## Microservices:

* user_service = 8082:8082
* wiki_core_service = 8081:8081

## Databases:

* user_db = 5432:5342
* article_db = 5431:5432
* keycloak_db = 5430:5432

## Additional tools:

* zookeeper = 22181:2181
* kafka1
    * "29092:29092"  # Для внутреннего / PLAINTEXT
    * "29093:29093"  # Для внешнего / PLAINTEXT_HOST
* kafka2
    * "29094:29094"  # Для внутреннего
    * "29095:29095"  # Для внешнего
* kafka-ui = 8090:8080
* keycloak_web = 8083:8080
* api_gatewat = 8084:8084
