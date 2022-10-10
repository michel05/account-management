package com.michel.accountmanagement.domain.gateway

import java.math.BigDecimal

interface AccountOperationsGateway {
    fun withdraw(identifier: String, amount: BigDecimal)
}