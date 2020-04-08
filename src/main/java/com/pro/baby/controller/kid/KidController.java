package com.pro.baby.controller.kid;

import com.pro.baby.entity.*;
import com.pro.baby.service.appoint.AppointApplicationService;
import com.pro.baby.service.kid.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class KidController {


    @Autowired
    private KidService kidService;
    @Autowired
    private AppointApplicationService appointApplicationService;


    //social界面
    @GetMapping("/social")
    public String social() {

        return "kid/social/social";
    }


    //清单
    @GetMapping("/history")
    public String history() {

        return "kid/social/history";
    }


    //    预约详情
    @GetMapping("/socialDetail")
    public String socialDetails(int appID, Model model) {
//        AppointApplication appointApplication=appointApplicationService.backDetail(appID);
//
//        model.addAttribute("app",appointApplication);
        return "kid/social/details";
    }


    //    预约
    @GetMapping("/toSocial")
    public String toSocialIndex() {

        return "kid/social/toSocial";
    }

    @PostMapping("/toSocial")
    @ResponseBody
    public int toSocial(HttpSession session, Address address, String startDay, String stopDay, String startTime, String stopTime, String kids, String ps) {
        Parent parent = (Parent) session.getAttribute("parent");


//        时间处理
        AppTime appTime = new AppTime();

        LocalDate startDay1 = LocalDate.parse(startDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate stopDay1 = LocalDate.parse(stopDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime startTime1 = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime stopTime1 = LocalTime.parse(stopTime, DateTimeFormatter.ofPattern("HH:mm:ss"));

        appTime.setStartDay(startDay1);
        appTime.setStopDay(stopDay1);
        appTime.setStartTime(startTime1);
        appTime.setStopTime(stopTime1);

//   参与者（kid

        String[] kidList = kids.split(",");
        List<Integer> aa = new ArrayList<>();
        System.out.println(kidList.length);
        for (String s : kidList) {
            System.out.println(s);
            aa.add(Integer.parseInt(s));
        }

        Set<Kid> kidSet = new HashSet<>();
        kidSet = kidService.backKidSet(aa);


        AppointApplication appointApplication = new AppointApplication();
        appointApplication.setParent(parent);
        appointApplication.setKids(kidSet);
        appointApplication.setAddress(address);
        appointApplication.setAppTime(appTime);
        appointApplication.setPs(ps);//备注  ps

        return appointApplicationService.createApp(appointApplication);
    }


}
