package com.longho.cocsearch.controller;

import com.longho.cocsearch.apihanlder.CocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by leho on 2/24/17.
 */
@Controller
public class HomeController {

    @Autowired
    CocService cocService;

    @RequestMapping(value = "/")
    public String Hello(){
        return "index";
    }

    @RequestMapping(value="/clan/get", method = RequestMethod.GET)
    public @ResponseBody Object getClann(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "limit", defaultValue = "5") int limit,
            @RequestParam(value = "after", defaultValue = "") String after,
            @RequestParam(value = "before", defaultValue = "") String before){
        return cocService.getClansByName(name, limit,before,after);
    }

    @RequestMapping(value="/clan", method = RequestMethod.GET)
    public @ResponseBody Object getClann(
            @RequestParam(value = "tag") String tag){
        return cocService.getClanByTag(tag);
    }

}
