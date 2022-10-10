package com.michel.accountmanagement.application.controller

import com.devpass.michel.accountmanagement.application.controller.dto.AccountWithdrawRequest
import com.devpass.michel.accountmanagement.domain.gateway.AccountOperationsGateway
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("account")
class AccountOperationsController(
    val accountOperationsGateway: AccountOperationsGateway,
) {

    @PostMapping("/withdraw")
    fun createNewClient(
        @RequestBody accountWithdrawRequest: AccountWithdrawRequest
    ): ResponseEntity<Void> {
        accountOperationsGateway.withdraw(accountWithdrawRequest.identifier, accountWithdrawRequest.amount)
        return ResponseEntity.accepted().build()
    }
}