package com.pro.baby.service.diary;


import com.pro.baby.entity.Diary;
import com.pro.baby.entity.DiaryType;
import com.pro.baby.repository.DiaryRepository;
import com.pro.baby.repository.DiaryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {


    @Autowired
    private DiaryRepository diaryRepository;


    //写日记
    public int addDiary(Diary diary) {
        diaryRepository.save(diary);
        return diary.getDiaryID();
    }

    public List<DiaryType> backDiaryTypes(int parentID) {
        List<DiaryType> diaryTypes = diaryTypeRepository.findByParent(parentID);
        return diaryTypes;
    }

    public List<DiaryType> backAllDiaryTypes() {
        List<DiaryType> allDiaryTypes = diaryTypeRepository.findAll();
        return allDiaryTypes;
    }
    public DiaryType getOne(int diaryTypeID){
        return diaryTypeRepository.getOne(diaryTypeID);
    }


    //    展示日记
    public Diary diaryShow(int diaryID) {

        return diaryRepository.getOne(diaryID);
    }

    public List<Diary> diaries() {
        return diaryRepository.findAll();
    }


//    修改日记


//    删除日记


//    类型

    //    添加类型
    @Autowired
    private DiaryTypeRepository diaryTypeRepository;

    public DiaryType addDiaryType(DiaryType diaryType) {
        return diaryTypeRepository.save(diaryType);
    }


}
