package com.michel.accountmanagement.domain.service

import com.devpass.michel.accountmanagement.domain.exceptions.NotFoundException
import com.devpass.michel.accountmanagement.domain.gateway.ClientManagerGateway
import com.devpass.michel.accountmanagement.domain.model.Account
import com.devpass.michel.accountmanagement.domain.model.AccountStatus
import com.devpass.michel.accountmanagement.domain.model.Client
import com.devpass.michel.accountmanagement.domain.model.CreateClient
import com.devpass.michel.accountmanagement.domain.repositories.ClientRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.random.Random

@Service
class ClientManagerService(
    private val clientRepository: ClientRepository
) : ClientManagerGateway {

    override fun saveClient(createClient: CreateClient): Client {
        val account = Account(
            accountNumber = Random.nextInt(0, 10000).toString().padStart(7, '0'),
            balance = BigDecimal(1000),
            status = AccountStatus.ACTIVE
        )

        val client = Client(
            name = createClient.name,
            birthDate = createClient.birthDate,
            identifier = createClient.identifier,
            account = account
        )
        return clientRepository.save(client)
    }

    override fun listClients(): List<Client> {
        return clientRepository.findAll()
    }

    override fun getClient(identifier: String): Client {
        return clientRepository.findByIdentifier(identifier)
            ?: throw NotFoundException("client", "Client $identifier not found")
    }
}