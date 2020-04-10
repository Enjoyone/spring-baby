package com.pro.baby.repository;

import com.pro.baby.entity.Parent;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Parent, Integer> {


    //    根据userName查询  status-->true
    List<Parent> findParentByUserNameAndStatusTrue(String userName);

    //    userName  是否存在
    boolean existsParentByUserName(String userName);

    //返回所有
    List<Parent> findAllByParentIDNotNull();

}
