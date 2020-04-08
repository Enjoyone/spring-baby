package com.pro.baby.controller.diary;

import com.pro.baby.entity.Diary;
import com.pro.baby.entity.DiaryType;
import com.pro.baby.entity.Parent;
import com.pro.baby.service.diary.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DiaryController {

    @Autowired
    private DiaryService diaryService;


    //    日记社区
    @GetMapping("/community")
    public String community() {
//        数据


        return "diary/community";
    }


//写日记

    @GetMapping("/writeDiary")
    public String toAddDiary(Model model, HttpSession session) {
        Parent parent = (Parent) session.getAttribute("parent");
        List<DiaryType> diaryTypes = diaryService.backDiaryTypes(parent.getParentID());
        model.addAttribute("diaryTypes", diaryTypes);

        return "diary/diaryWrite";
    }


    @PostMapping("/writeDiary")
    @ResponseBody
    public int addDiary(String diaryTitle, String diaryContent, int diaryType, HttpSession session) {

        Parent parent = (Parent) session.getAttribute("parent");

        DiaryType diaryType1 = diaryService.getOne(diaryType);

        Diary diary = new Diary();
        diary.setDiaryTitle(diaryTitle);
        diary.setDiaryContent(diaryContent);

        diary.setParent(parent);
        diary.setDiaryType(diaryType1);

        return diaryService.addDiary(diary);
    }


    //    展示日记
    @GetMapping("/showDiary")
    public String diaryShow(int diaryID, Model model) {
        Diary diary = diaryService.diaryShow(diaryID);
        model.addAttribute("diary", diary);

        return "diary/diaryShow";
    }


//    修改日记


//    删除日记


    //    类型
//    1 添加
    @GetMapping("/addDiaryType")
    @ResponseBody
    public String addDiaryType(DiaryType diaryType, HttpSession session) {
        Parent parent = (Parent) session.getAttribute("parent");
        diaryType.setParent(parent);

        diaryService.addDiaryType(diaryType);

        return "1";//  判断（后期）
    }


//    @GetMapping("/showType")
//    @ResponseBody
//    public String showType() {
//        List<DiaryType> diaryTypes = diaryService.showAllTypes();
//        return "showType";
//    }


}
