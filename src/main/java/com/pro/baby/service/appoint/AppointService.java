package com.pro.baby.service.appoint;

import com.pro.baby.entity.Appoint;
import com.pro.baby.repository.AppointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointService {

    @Autowired
    private AppointRepository appointRepository;


    //    create
    public int add(Appoint appoint) {
         appointRepository.save(appoint);
        return appoint.getAppointID();
    }

//
    public Appoint getOne(int appointID){
        return appointRepository.getOne(appointID);
    }


    public List<Appoint> backbyParentID(int parentID){
        return appointRepository.backByParentID(parentID);
    }


    public List<Appoint> backAll(){

        return appointRepository.findAll();
    }


}
