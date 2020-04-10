package com.pro.baby.service.kid;


import com.pro.baby.entity.Kid;
import com.pro.baby.entity.Parent;
import com.pro.baby.repository.KidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KidService {

    @Autowired
    private KidRepository kidRepository;


    //    返回参与儿童
    public Set<Kid> backKidSet(List<Integer> kidID) {
        Set<Kid> kidSet = new HashSet<>();

        for (int i : kidID
        ) {
            kidSet.add(kidRepository.getOne(i));
        }
        return kidSet;
    }

//添加孩子
    public void addKid(Kid kid) {
        kidRepository.save(kid);



    }
    //删除孩子
    public void deleteKid(int kidID){
        kidRepository.deleteById(kidID);
    }

    public List<Kid> findBabyByParent(Parent parent) {
        return kidRepository.findAllByParent(parent);
    }
}
