package mvctest.domain

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Hotel(
        @Id @GeneratedValue var id: Long?,
        @field:NotEmpty var name: String,
        @field:NotEmpty var address: String,
        @field:NotEmpty var zip: String
)