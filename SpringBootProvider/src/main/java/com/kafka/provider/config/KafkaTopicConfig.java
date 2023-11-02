package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

/*
    Clase de configuración de los topics de kafka
    La etiqueta Configuration permite indicarle a Spring que la clase configurara componentes en la app que se debe de
    cargar al inicio de la app y que los beans definidos en esta clase estaran disponibles para inyectarse en otros
    componentes de la app.
    En kafka  las clases anotadas con @Configuration se usan para definir @Bean que representen propiedades de configuracion
    de Kafka como topics que se usarán en otros lugares de la app

 */
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic(){
        Map<String, String> configurations = new HashMap<>();
        // Aquí configuramos las características del topic,
        // delete -> borra el mensaje despues de cierto tiempo, compact -> mantiene el más actual de los mensajes repetidos
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        //Cuanto tiempo se retienen los mensajes en el topic, 86400000ms = 1 dia, por defecto no se borran
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        //Cuanto tamaño puede tener como max cada segmento en bytes, 1073741824 bytes -> 1GB
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        //Tamaño máximo de cada mensaje - defecto 1 MB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");
        return TopicBuilder.name("twitter-Topic")
                .partitions(2)
                // Quiero 2 replicas más por si esta se cae
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
