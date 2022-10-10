package com.michel.accountmanagement.application.controller.dto

import java.math.BigDecimal

data class AccountWithdrawRequest(
    val identifier: String,
    val amount: BigDecimal
)