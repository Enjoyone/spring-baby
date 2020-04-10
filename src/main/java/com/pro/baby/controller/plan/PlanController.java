package com.pro.baby.controller.plan;

import com.pro.baby.entity.Plan;
import com.pro.baby.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping("/addPlan")
    public String addPlan(){
        return "/admin/recommendPlan/recommendPlanadd";
    }

    @PostMapping("/addPlan")
    public String addPlan(String title,String age,String type,String content){
        Plan plan = new Plan();
        plan.setAge(age);
        plan.setContent(content);
        plan.setTitle(title);
        plan.setType(type);
        planService.addPlan(plan);
        return "redirect:/planManage";

    }

    @GetMapping("/planManage")
    public String planManage(Model model){
        List<Plan> plans ;
           plans= planService.findAll();
        model.addAttribute("plans",plans);
        return "/admin/recommendPlan/Planmanage";
    }

    @PostMapping("/admindeletePlan")
    @ResponseBody
    public String admindeletePlan(int planID){
        planService.deletePlanById(planID);
        return "1";

    }

}
