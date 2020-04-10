package com.pro.baby.controller.schedule;

import com.pro.baby.entity.Parent;
import com.pro.baby.entity.RecommendPlan;
import com.pro.baby.entity.Schedule;
import com.pro.baby.service.schedule.RecommendService;
import com.pro.baby.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private RecommendService recommendService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/plan")
    public String planshow(Model model, HttpSession session){
        if(session.getAttribute("parent")!=null){
            List<RecommendPlan> recommendPlans = recommendService.findAllbyParent((Parent)session.getAttribute("parent"));
            System.out.println(((Parent) session.getAttribute("parent")).getParentID());
            model.addAttribute("recommendPlans",recommendPlans);

            List<Schedule> schedules = scheduleService.findAllByParent((Parent)session.getAttribute("parent"));
            model.addAttribute("scheduls",schedules);


            return "plan/plan";
        }
        else
            return "redirect:/login";

    }
    // scheduleTitle;
    //    private String scheduleContent;
    //
    //    private LocalDate scheduleCreateTime=LocalDate.now();
    //    private LocalDate scheduleRemindTime;
    //    private String location;
    @PostMapping("/addSchedule")
    public String addSchedule(HttpSession session,String scheduleTitle, String scheduleContent, String scheduleRemindTime,String location){
        Schedule schedule = new Schedule();
        schedule.setParent((Parent)session.getAttribute("parent"));
        schedule.setLocation(location);
        schedule.setScheduleTitle(scheduleTitle);
        schedule.setScheduleContent(scheduleContent);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
        LocalDate date = LocalDate.parse(scheduleRemindTime,df);
        schedule.setScheduleRemindTime(date);
        scheduleService.addSchedule(schedule);

        return "redirect:plan";
    }

}
