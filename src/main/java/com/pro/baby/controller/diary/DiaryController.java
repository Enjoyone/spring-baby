package com.pro.baby.controller.diary;

import com.pro.baby.entity.ArticleType;
import com.pro.baby.entity.Diary;
import com.pro.baby.entity.DiaryType;
import com.pro.baby.entity.Parent;
import com.pro.baby.service.diary.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/addDiary")
    public String toAddDiary(HttpServletRequest request) {
        HttpSession httpSession=request.getSession();
        Parent parent= (Parent) httpSession.getAttribute("parent");
        System.out.println("adddiary:"+parent.getUserName());
        List<DiaryType> diaryTypes = diaryService.backDiaryTypes(parent.getParentID());
        return "diary/diaryWrite";
    }

    @PostMapping("/addDiary")
    public String addDiary(Model model, Diary diary) {
        int diaryID = diaryService.addDiary(diary);
        model.addAttribute("diaryID", diaryID);
        return "forward:diaryShow";
    }


    //    展示日记
    @GetMapping("/diaryShow")
    public String diaryShow(int diaryID) {
        Diary diary = diaryService.diaryShow(diaryID);
        return "diary/diaryShow";
    }


//    修改日记


//    删除日记


    //    类型
//    1 添加
    @GetMapping("/addDiaryType")
    @ResponseBody
    public DiaryType addDiaryType(DiaryType diaryType) {
        return diaryService.addDiaryType(diaryType);
    }
}
