package com.pro.baby.service.appoint;


import com.pro.baby.entity.AppointApplication;
import com.pro.baby.repository.AppointApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointApplicationService {

    @Autowired
    private AppointApplicationRepository appointApplicationRepository;

//    create


    //    返回
    public AppointApplication backDetail(int appID) {

        return appointApplicationRepository.getOne(appID);
    }


    //  添加预约单
    public AppointApplication createApp(AppointApplication appointApplication) {
        return appointApplicationRepository.save(appointApplication);

    }


}
