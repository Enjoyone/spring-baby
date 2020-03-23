package com.pro.baby.service.user;


import com.pro.baby.entity.Parent;
import com.pro.baby.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //    注册
    public Parent addUser(Parent parent) {
        return userRepository.save(parent);
    }


    //    登录
    public Parent loginCheck(String userName, String pwd) {
        Parent parent = userRepository.findByUserNameAndStatusTrue(userName);
        if (pwd.equals(parent.getPwd())) {
//            session

            return parent;
        } else {
            return null;
        }
    }


}
