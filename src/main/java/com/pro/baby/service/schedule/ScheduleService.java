package com.pro.baby.service.schedule;

import com.pro.baby.entity.Parent;
import com.pro.baby.entity.Schedule;
import com.pro.baby.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> findAllByParent(Parent parent) {
        return scheduleRepository.findAllByParent(parent);
    }

    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
