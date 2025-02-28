package org.schola.spring.reception.microservice.data.repository;

import org.schola.spring.reception.microservice.data.model.Reception;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionMongoRepository extends MongoRepository<Reception, String> {

    List<Reception> findByUser(String user);
    
}
