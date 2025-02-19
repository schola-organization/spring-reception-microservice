package org.schola.spring.reception.microservice.data.service

import org.schola.spring.reception.microservice.data.model.RECEPTION_KEY
import org.schola.spring.reception.microservice.data.model.Reception
import org.schola.spring.reception.microservice.data.repository.ReceptionMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReceptionService {

    @Autowired
    private lateinit var mongo: ReceptionMongoRepository

    @CachePut(value = [RECEPTION_KEY], key = "#reception.id")
    fun save(reception: Reception) {
        mongo.save(reception)
    }

    @Cacheable(value = [RECEPTION_KEY], key = "#id")
    fun get(id: String): Reception = mongo.findById(id).orElse(null)

    @Cacheable(value = [RECEPTION_KEY])
    fun getAll(pageable: Pageable): List<Reception> = mongo.findAll(pageable).content

    @CacheEvict(value = [RECEPTION_KEY], allEntries = true)
    fun delete(id: String) = mongo.deleteById(id)

}
