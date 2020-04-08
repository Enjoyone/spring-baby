package com.pro.baby.repository;
import com.pro.baby.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    //查找管理员用户
    List<Admin> findAdminByUserName(String userName) ;
}