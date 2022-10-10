package com.michel.accountmanagement.domain.exceptions

import java.lang.Exception

class NotFoundException(
    val resource: String,
    override val message: String?
) : Exception(message)