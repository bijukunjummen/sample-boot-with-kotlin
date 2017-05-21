package mvctest

import mvctest.domain.Hotel
import mvctest.service.HotelRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbPopulator(private val hotelRepository: HotelRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        for (i in 1..10) {
            hotelRepository.save(Hotel(name = "Hotel $i", address = "Address $i", zip = "Zip $i", id = null))
        }
    }
}