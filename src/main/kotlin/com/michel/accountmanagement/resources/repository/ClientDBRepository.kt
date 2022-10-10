package com.michel.accountmanagement.resources.repository

import com.michel.accountmanagement.domain.model.Client
import com.michel.accountmanagement.domain.repositories.ClientRepository
import com.michel.accountmanagement.resources.repository.data.ClientDataJpaRepository
import com.michel.accountmanagement.resources.repository.entities.AccountEntity
import com.michel.accountmanagement.resources.repository.entities.ClientEntity
import org.springframework.stereotype.Repository

@Repository
class ClientDBRepository(
    private val clientDataJpaRepository: ClientDataJpaRepository
) : ClientRepository {
    override fun save(client: Client): Client {
        val clientEntity = ClientEntity(
            id = client.id,
            name = client.name,
            identifier = client.identifier,
            birthDate = client.birthDate,
            account = AccountEntity(
                accountNumber = client.account.accountNumber,
                balance = client.account.balance,
                status = client.account.status
            )
        )
        return clientDataJpaRepository.save(clientEntity).toDomain()
    }

    override fun findAll(): List<Client> {
        return clientDataJpaRepository.findAll().map { it.toDomain() }
    }

    override fun findByIdentifier(identifier: String): Client? {
        return clientDataJpaRepository.findByIdentifier(identifier)?.toDomain()
    }
}