package mvctest.service

import mvctest.domain.Hotel
import org.springframework.data.repository.CrudRepository

interface HotelRepository: CrudRepository<Hotel, Long>