package com.pro.baby.service.appTime;

import com.pro.baby.entity.AppTime;
import com.pro.baby.repository.AppTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppTimeService {


    @Autowired
    private AppTimeRepository appTimeRepository;

//    add
    public int addAppTime(AppTime appTime){
        appTimeRepository.save(appTime);
        return appTime.getAppTimeID();
    }
}
