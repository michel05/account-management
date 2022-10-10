package com.michel.accountmanagement.application.controller

import com.devpass.michel.accountmanagement.application.controller.dto.ClientDtoRequest
import com.devpass.michel.accountmanagement.application.controller.dto.ClientResponseDTO
import com.devpass.michel.accountmanagement.domain.gateway.ClientManagerGateway
import com.devpass.michel.accountmanagement.domain.model.CreateClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("clients")
class ClientController(
    val clientManagerGateway: ClientManagerGateway,
) {

    @PostMapping
    fun createNewClient(
        @RequestBody clientDtoRequest: ClientDtoRequest
    ): ResponseEntity<ClientResponseDTO> {
        return ResponseEntity.ok(
            ClientResponseDTO(
                clientManagerGateway.saveClient(
                    CreateClient(
                        name = clientDtoRequest.name,
                        birthDate = clientDtoRequest.birthDate,
                        identifier = clientDtoRequest.identifier
                    )
                )
            )
        )
    }

    @GetMapping
    fun listAllClients(): List<ClientResponseDTO> {
        val listOfClients = clientManagerGateway.listClients()
        return listOfClients.map { ClientResponseDTO(it) }
    }

    @GetMapping("/:identifier")
    fun getClient(
        @PathVariable(value = "identifier") identifier: String
    ): ResponseEntity<ClientResponseDTO> {
        return ResponseEntity.ok(
            ClientResponseDTO(
                clientManagerGateway.getClient(identifier)
            )
        )
    }
}