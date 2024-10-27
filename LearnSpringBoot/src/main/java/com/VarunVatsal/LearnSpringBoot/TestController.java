package com.VarunVatsal.LearnSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class TestController {

    @RequestMapping("/test")
    public String firstHandler(){
        return "Hello World";
    }
}
