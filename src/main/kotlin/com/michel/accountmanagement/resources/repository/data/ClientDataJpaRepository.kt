package com.michel.accountmanagement.resources.repository.data

import com.michel.accountmanagement.resources.repository.entities.ClientEntity
import org.springframework.data.repository.CrudRepository

interface ClientDataJpaRepository : CrudRepository<ClientEntity, Int> {

    fun findByIdentifier(identifier: String): ClientEntity?
}
