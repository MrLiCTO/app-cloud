package com.lingxin.cloud.ui.app.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mr_Li on 2016/9/27.
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("person");
    }

}
