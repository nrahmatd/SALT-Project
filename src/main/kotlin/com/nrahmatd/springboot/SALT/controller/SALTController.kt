package com.nrahmatd.springboot.SALT.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@Controller
class SALTController {
    @RequestMapping(path = ["/"], method = [RequestMethod.GET])
    open fun goHome(): String? {
        return "index"
    }

    @RequestMapping(path = ["/addcustomer"], method = [RequestMethod.GET])
    fun showAddCustomerForm(): String? {
        return "add-customer"
    }
}