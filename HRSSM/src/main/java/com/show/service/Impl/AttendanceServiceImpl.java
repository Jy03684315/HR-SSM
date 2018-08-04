package com.show.service.Impl;

import com.show.dao.AttendanceMapper;
import com.show.model.Attendance;
import com.show.model.Staff;
import com.show.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/8/4.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceMapper attendanceMapper;

    public void addOn(Attendance attendance) {
        attendanceMapper.addOn(attendance);
    }

    public Attendance getOnNow(int sid, int month, int day) {
        return attendanceMapper.getOnNow(sid,month,day);
    }

    public void addOff(Attendance attendance) {
        attendanceMapper.addOff(attendance);
    }


}
