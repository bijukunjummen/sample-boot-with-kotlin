package mvctest.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RootController {
    
    @RequestMapping("/")
    fun rootCall(): String {
        return "redirect:/hotels"
    }
}