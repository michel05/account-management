package com.michel.accountmanagement.application.controller.dto

import com.michel.accountmanagement.domain.model.Account
import com.michel.accountmanagement.domain.model.Client
import java.math.BigDecimal
import java.time.LocalDate

data class ClientResponseDTO(
    val name: String,
    val identifier: String,
    val birthDate: LocalDate?,
    val account: AccountResponseDTO
) {
    constructor(client: Client) : this(
        name = client.name,
        identifier = client.identifier,
        birthDate = client.birthDate,
        account = AccountResponseDTO(client.account)
    )
}

data class AccountResponseDTO(
    val accountNumber: String,
    val balance: BigDecimal,
) {
    constructor(account: Account) : this(
        accountNumber = account.accountNumber,
        balance = account.balance
    )
}