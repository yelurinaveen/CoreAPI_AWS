package com.adiye.happyhome.coreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nyeluri on 11/14/16.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(path="/scaling", method = RequestMethod.GET)
    @ResponseBody
    public String doScaling(){
        return "Hi there. Just a dummy implementation for scaling";
    }
}
