package com.michel.accountmanagement.domain.service

import com.devpass.michel.accountmanagement.domain.exceptions.NotFoundException
import com.devpass.michel.accountmanagement.domain.gateway.AccountOperationsGateway
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