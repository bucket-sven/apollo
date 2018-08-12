package com.sven.game.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class MainController {
    @RequestMapping("/", method = [ RequestMethod.GET ])
    fun index(): String {
        return "main/index"
    }
}