package com.michel.accountmanagement.domain.service

import com.michel.accountmanagement.domain.exceptions.NotFoundException
import com.michel.accountmanagement.domain.gateway.AccountOperationsGateway
import com.michel.accountmanagement.domain.model.Client
import com.michel.accountmanagement.domain.repositories.ClientRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountOperationService(
    private val clientRepository: ClientRepository
) : AccountOperationsGateway {

    override fun withdraw(identifier: String, amount: BigDecimal) {
        val client: Client = clientRepository.findByIdentifier(identifier)
            ?: throw NotFoundException("client", "Client $identifier not found")
        client.account.balance -= amount
        clientRepository.save(client)
    }
}