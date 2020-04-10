package com.pro.baby.service.user;


import com.pro.baby.entity.Parent;
import com.pro.baby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //    注册
    public Parent addUser(Parent parent) {
        userRepository.save(parent);
        System.out.println("id:"+parent.getParentID());
        if (userRepository.existsParentByUserName(parent.getUserName())){
            return parent;
        }else{
            return  null;
        }
    }


    //    登录
    public Parent loginCheck(String userName, String pwd) {
        System.out.println("service:"+userName);
        List<Parent> parents = userRepository.findParentByUserNameAndStatusTrue(userName);
        if (pwd.equals(parents.get(0).getPwd())) {
            System.out.println("service get:"+parents.get(0).getUserName());
            return parents.get(0);
        } else {
            return null;
        }
    }

    public List<Parent> AllParents(){
        return userRepository.findAll();
    }



}
