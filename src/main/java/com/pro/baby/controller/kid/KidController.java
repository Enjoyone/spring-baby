package com.pro.baby.controller.kid;

import com.pro.baby.entity.*;
import com.pro.baby.service.address.AddressService;
import com.pro.baby.service.appTime.AppTimeService;
import com.pro.baby.service.appoint.AppointService;
import com.pro.baby.service.kid.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private AppTimeService appTimeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private AppointService appointService;

    //social界面
    @GetMapping("/social")
    public String social(HttpSession session, Model model) {
        //    未来预约
        Parent parent = (Parent) session.getAttribute("parent");
//        个人所有
//        List<Appoint> appoints = appointService.backbyParentID(parent.getParentID());
// 个人未来
        List<Appoint> appointList = appointService.willAppoint(parent.getParentID());
//        for (Appoint a:appointList
//             ) {
//            System.out.println(a.getAppTime().getFinalDay());
//        }

        model.addAttribute("appointList", appointList);


        return "kid/social/social";
    }


    //清单//    所有预约
    @GetMapping("/history")
    public String history(Model model, HttpSession session) {
        Parent parent = (Parent) session.getAttribute("parent");
        List<Appoint> appoints = appointService.backbyParentID(parent.getParentID());
        model.addAttribute("appoints", appoints);
        return "kid/social/history";
    }


    //    预约详情
    @GetMapping("/socialDetail")
    public String socialDetails(int appointID, Model model) {
        Appoint appoint = appointService.getOne(appointID);
        model.addAttribute("appoint", appoint);

        return "kid/social/details";
    }


    //    预约
    @GetMapping("/toSocial")
    public String toSocialIndex(Model model, HttpSession session) {
        Parent parent = (Parent) session.getAttribute("parent");
        List<Kid> kids = new ArrayList<>();
        kids = kidService.backKidOfParent(parent.getParentID());
        model.addAttribute("kids", kids);
        return "kid/social/toSocial";
    }

    @PostMapping("/toSocial")
    @ResponseBody
    public int toSocial(HttpSession session, String province, String city, String district, String details, String startDay, String stopDay, String startTime, String stopTime, String kids, String ps) {
        Parent parent = (Parent) session.getAttribute("parent");

//地址
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetails(details);


//        存储返回id
        int addressID = addressService.addAddress(address);


//        时间处理
        AppTime appTime = new AppTime();
        System.out.println(startDay);
        System.out.println(stopDay);
        System.out.println(startTime);
        System.out.println(stopTime);

        LocalDate startDay1 = LocalDate.parse(startDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate stopDay1 = LocalDate.parse(stopDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime startTime1 = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime stopTime1 = LocalTime.parse(stopTime, DateTimeFormatter.ofPattern("HH:mm:ss"));

        appTime.setStartDay(startDay1);
        appTime.setStopDay(stopDay1);
        appTime.setStartTime(startTime1);
        appTime.setStopTime(stopTime1);
        int appTimeID = appTimeService.addAppTime(appTime);

//   参与者（kid

        String[] kidList = kids.split(",");
        List<Integer> aa = new ArrayList<>();

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
        //        一开始
        Set<Parent> parents = new HashSet<>();
        parents.add(parent);


        Appoint appoint = new Appoint();
        appoint.setParent(parent);
        appoint.setParents(parents);
        appoint.setKids(kidSet);
        appoint.setAddress(address);
        appoint.setAppTime(appTime);
        appoint.setPs(ps);

        return appointService.add(appoint);
    }

}
