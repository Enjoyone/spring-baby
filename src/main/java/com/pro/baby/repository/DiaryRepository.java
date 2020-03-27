package com.pro.baby.repository;

import com.pro.baby.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiaryRepository extends JpaRepository<Diary,Integer> {











//        @Query("select a from User a where a.guid = ?1 and a.is_deleted = 0")
//        Reservation getUserByGuid(String guid);
//
//        @Query("select a from User a where a.is_deleted = 0")
//        List<Reservation> findAll();
//
//        @Query(value = "select sum(visit_num) from user t where t.vtime=?2 and t.vdate=?1 and t.is_deleted = 0",nativeQuery = true)
//        int findReservationsCountByVisit_dateAndVisit_time(String vdate, Integer vtime);
//
//        @Modifying
//        @Query(value = "update User a set a.is_deleted = 1 where a.guid = :guid")
//        void deleteUserByGuid(@Param("guid") String guid);


}
