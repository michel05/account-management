package com.michel.accountmanagement.domain.model

import java.time.LocalDate

data class CreateClient(
    val name: String,
    val birthDate: LocalDate?,
    val identifier: String
)
