package com.michel.accountmanagement.domain.gateway

import com.michel.accountmanagement.domain.model.Client
import com.michel.accountmanagement.domain.model.CreateClient

interface ClientManagerGateway {
    fun saveClient(createClient: CreateClient): Client
    fun listClients(): List<Client>
    fun getClient(identifier: String): Client
}