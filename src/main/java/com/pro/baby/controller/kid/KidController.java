package com.pro.baby.controller.kid;

import com.pro.baby.entity.*;
import com.pro.baby.service.address.AddressService;
import com.pro.baby.service.appTime.AppTimeService;
import com.pro.baby.service.appoint.AppointApplicationService;
import com.pro.baby.service.kid.KidService;
import com.pro.baby.service.plan.PlanService;
import com.pro.baby.service.schedule.RecommendService;
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
import java.time.temporal.ChronoUnit;
import java.util.*;

@Controller
public class KidController {


    @Autowired
    private KidService kidService;
    @Autowired
    private AppointApplicationService appointApplicationService;
    @Autowired
    private AppTimeService appTimeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PlanService planService;
    @Autowired
    private RecommendService recommendService;

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
    public int toSocial(HttpSession session, String province, String city, String district, String details, String startDay, String stopDay, String startTime, String stopTime, String kids, String ps) {
        Parent parent = (Parent) session.getAttribute("parent");

//地址
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetails(details);
//        存储返回id
        int addressID=addressService.addAddress(address);


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
        int appTimeID=appTimeService.addAppTime(appTime);

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

        return appointApplicationService.createApp(appointApplication);
    }


    //添加孩子
    @PostMapping("/addKid")
    public String addKid(String name,String birth,String gender,String character,String hobby,Model model,HttpSession session){
        Kid kid = new Kid();
        kid.setCharacter(character);
        kid.setGender(gender);
        kid.setHobby(hobby);
        kid.setName(name);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        kid.setBirth(LocalDate.parse(birth,df));
        Parent parent = (Parent)session.getAttribute("parent");
        kid.setParent(parent);
        kid.setAge(kid.getBirth().until(LocalDate.now()).getYears());
        kidService.addKid(kid);


        //生成相关推荐

        LocalDate date = kid.getBirth();

        List<Plan> plans = planService.findAll();
        for(int i =0;i<plans.size();i++){
            Plan p = plans.get(i);
            RecommendPlan r = new RecommendPlan();
            r.setParent(parent);
            r.setRecommendPlanContent(p.getContent());
            r.setRecommendPlanTitle(p.getTitle());
            LocalDate redate;
            if(p.getAge().equals("1个月")){
                redate = date.plusMonths(1);
            }
            else if(p.getAge().equals("2个月")){
                redate = date.plusMonths(2);
            }
            else if(p.getAge().equals("3个月")){
                redate = date.plusMonths(3);
            }
            else if(p.getAge().equals("4个月")){
                redate = date.plusMonths(4);
            }
            else if(p.getAge().equals("5个月")){
                redate = date.plusMonths(5);
            }
            else if(p.getAge().equals("6个月")){
                redate = date.plusMonths(6);
            }
            else if(p.getAge().equals("7个月")){
                redate = date.plusMonths(7);
            }
            else if(p.getAge().equals("8个月")){
                redate = date.plusMonths(8);
            }
            else if(p.getAge().equals("9个月")){
                redate = date.plusMonths(9);
            }
            else if(p.getAge().equals("9-12个月")){
                redate = date.plusMonths(10);
            }
            else if(p.getAge().equals("12-18个月")){
                redate = date.plusMonths(12);
            }
            else if(p.getAge().equals("18-24个月")){
                redate = date.plusMonths(18);
            }
            else if(p.getAge().equals("24-36个月")){
                redate = date.plusMonths(24);
            }
            else if(p.getAge().equals("36个月")){
                redate = date.plusMonths(36);
            }
            else if(p.getAge().equals("48个月")){
                redate = date.plusMonths(48);
            }
            else if(p.getAge().equals("6岁")){
                redate = date.plusMonths(74);
            }
            else
                redate = date;

            r.setRecommendPlanRemindTime(redate);
            recommendService.addPlan(r);

        }
//        //得到月份
//        long age = date.until(LocalDate.now(), ChronoUnit.MONTHS);

        return "redirect:/mybaby";
    }

    @GetMapping("/mybaby")
    public String getMybaby(Model model,HttpSession session){
        Parent parent = (Parent)session.getAttribute("parent");
        if(parent!=null){
            List<Kid> kids = kidService.findBabyByParent(parent);
            model.addAttribute("kids",kids);
            return "/kid/myKids";
        }
        else
            return "redirect:/login";
    }


}
