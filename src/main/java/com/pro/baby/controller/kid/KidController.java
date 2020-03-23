package com.pro.baby.controller.kid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KidController {




    @GetMapping("/social")
    public String social(){



        return "kid/social";
    }

}
