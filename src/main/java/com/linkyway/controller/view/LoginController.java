/*
 * © 2016 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package com.linkyway.controller.view;

import com.linkyway.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huseyin.kilic
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @RequestMapping
    public String loginView(Model model) {
        model.addAttribute("content", "login");
        return "master";
    }
}