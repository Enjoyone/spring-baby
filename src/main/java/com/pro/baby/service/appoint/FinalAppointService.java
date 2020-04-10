package com.pro.baby.service.appoint;


import com.pro.baby.entity.FinalAppoint;
import com.pro.baby.repository.FinalAppointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalAppointService {

    @Autowired
    private FinalAppointRepository finalAppointRepository;


    public int backID(FinalAppoint finalAppoint) {
        finalAppointRepository.save(finalAppoint);
        return finalAppoint.getFinalAppointID();
    }

    public FinalAppoint backOne(int finalAppointID) {
        return finalAppointRepository.getOne(finalAppointID);
    }


}
