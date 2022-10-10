package com.michel.accountmanagement.resources.repository.entities

import com.devpass.michel.accountmanagement.domain.model.Account
import com.devpass.michel.accountmanagement.domain.model.AccountStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "account")
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val accountNumber: String,

    var balance: BigDecimal,

    @Enumerated(value = EnumType.STRING)
    var status: AccountStatus
) {
    fun toDomain() = Account(
        id = this.id,
        accountNumber = this.accountNumber,
        balance = this.balance,
        status = this.status
    )
}

