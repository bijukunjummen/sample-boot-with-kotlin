package mvctest.web

import mvctest.domain.Hotel
import mvctest.service.HotelRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun list(model: Model): String {
        val hotels = hotelRepository.findAll()
        model.addAttribute("hotels", hotels)
        return "hotels/list"
    }

    @GetMapping(params = arrayOf("form"))
    fun createForm(model: Model): String {
        model.addAttribute("hotel", Hotel(0L, "", "", ""))
        return "hotels/create"
    }

    @PostMapping
    fun create(@Valid hotel: Hotel, bindingResult: BindingResult) =
            if (bindingResult.hasErrors()) {
                "hotels/create"
            } else {
                hotelRepository.save(hotel)
                "redirect:/hotels"
            }

    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable("id") id: Long, model: Model): String {
        model.addAttribute("hotel", hotelRepository.findOne(id))
        return "hotels/edit"
    }

    @PostMapping("/update")
    fun update(@Valid hotel: Hotel, bindingResult: BindingResult) =
            if (bindingResult.hasErrors()) {
                "hotels/edit"
            } else {
                hotelRepository.save(hotel)
                "redirect:/hotels"
            }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): String {
        hotelRepository.delete(id)
        return "redirect:/hotels"
    }
}