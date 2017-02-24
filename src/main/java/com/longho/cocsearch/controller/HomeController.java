package com.longho.cocsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by leho on 2/24/17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String Hello(){
        return "index";
    }
}
