package com.michel.accountmanagement.domain.model

import java.math.BigDecimal

data class Account(
    val id: Long? = null,
    val status: AccountStatus,
    val accountNumber: String,
    var balance: BigDecimal
)
