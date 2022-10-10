package com.michel.accountmanagement.resources.repository.entities

import com.devpass.michel.accountmanagement.domain.model.Client
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity(name = "client")
data class ClientEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val identifier: String,

    @Column(name = "birth_date")
    val birthDate: LocalDate?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id")
    val account: AccountEntity
) {

    fun toDomain(): Client {
        return Client(
            id = this.id,
            name = this.name,
            identifier = this.identifier,
            birthDate = this.birthDate,
            account = this.account.toDomain()
        )
    }
}
