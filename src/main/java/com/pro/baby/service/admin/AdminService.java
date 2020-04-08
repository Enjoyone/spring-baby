package com.pro.baby.service.admin;

import com.pro.baby.entity.Admin;
import com.pro.baby.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

 //管理员登录
    public boolean loginCheck(String userID, String userPWD) {
        List<Admin> admins = adminRepository.findAdminByUserName(userID);
        if(userPWD.equals(admins.get(0).getPwd())) {
//            System.out.println("service get:"+parents.get(0).getUserName());
            return true;
        }
        else {
            return false;
        }
//        return false;
    }
}
