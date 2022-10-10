package com.michel.accountmanagement.domain.repositories

import com.michel.accountmanagement.domain.model.Client


interface ClientRepository {

    fun save(client: Client): Client
    fun findAll(): List<Client>
    fun findByIdentifier(identifier: String): Client?
}