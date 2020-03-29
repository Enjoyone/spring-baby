package com.pro.baby.controller.kid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KidController {



//social界面
    @GetMapping("/social")
    public String social(){

        return "kid/social/social";
    }


//    预约
    @GetMapping("/toSocial")
    public String toSocial(){

        return "kid/social/toSocial";
    }


//清单
    @GetMapping("/history")
    public String history(){

        return "kid/social/history";
    }


}
