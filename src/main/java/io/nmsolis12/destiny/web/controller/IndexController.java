package io.nmsolis12.destiny.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
    @RequestMapping(value={"/", "/index", "/home"})
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "index";
    } 
}
