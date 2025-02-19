package org.schola.spring.reception.microservice.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.redis.core.RedisHash

const val RECEPTION_KEY = "receptions"

@Document(RECEPTION_KEY)
@RedisHash(RECEPTION_KEY)
data class Reception(

    @Id
    val id: String,

    val user: String,

    val status: ReceptionStatus,

    val date: String,

)

enum class ReceptionStatus {
    ENTRY,
    EXIT
}
