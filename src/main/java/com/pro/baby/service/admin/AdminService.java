package com.pro.baby.service.admin;

import com.pro.baby.entity.Admin;
import com.pro.baby.entity.Article;
import com.pro.baby.entity.Parent;
import com.pro.baby.repository.AdminRepository;
import com.pro.baby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;


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

//    public List<Parent> backNormalUser() {
//        return userRepository.findAllByParentIDNotNull();
//    }

    @Query(value="select top (select ?) * from  (select row_number() over(order by articleID) as rownumber,* from article) temp_row where rownumber>(?-1)*?")
    public List<Article> articlePageDao(int pageIndex, int i) {


        return  null;
    }

    public List<Boolean> changeUserStatus(String userID, boolean toStatus) {
        return null;
    }
}
