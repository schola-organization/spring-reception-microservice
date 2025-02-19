package org.schola.spring.reception.microservice.data.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.schola.spring.reception.microservice.data.repository.mongo")
public class MongoConfiguration {
}
