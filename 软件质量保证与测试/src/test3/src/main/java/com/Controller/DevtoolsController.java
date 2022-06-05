package com.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevtoolsController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "我是杨阳";
    }
}
