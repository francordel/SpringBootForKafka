# SpringBootForKafka
Demo repo for making a Provider - Consumer in Kafka
## Steps Before start

- Start zookeper
    - bin/zookeeper-server-start.sh config/zookeeper.properties 
    - It starts in port 2181

- Start Kafka server
    - bin/kafka-server-start.sh config/server.properties
    - It starts in port 9092

Run [SpringBootProviderApplication.java](SpringBootProvider%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkafka%2Fprovider%2FSpringBootProviderApplication.java)

Run [SpringBootConsumerApplication.java](src/main/java/com/kafka/consumer/SpringBootConsumer/SpringBootConsumerApplication.java)
### Check everything is correct
- List Kafka topics
    - bin/kafka-topics.sh --list --bootstrap-server localhost:9092
