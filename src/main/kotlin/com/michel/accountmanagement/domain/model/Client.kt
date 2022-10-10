package com.michel.accountmanagement.domain.model

import java.time.LocalDate

data class Client(
    val id: Long? = null,
    val name: String,
    val identifier: String,
    val birthDate: LocalDate?,
    val account: Account,
)
