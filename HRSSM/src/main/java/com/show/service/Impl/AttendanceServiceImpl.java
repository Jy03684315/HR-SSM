package com.show.service.Impl;

import com.show.dao.AttendanceMapper;
import com.show.model.Attendance;
import com.show.model.Staff;
import com.show.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public Attendance getOnNow(int sid, int month, int day,int year) {
        return attendanceMapper.getOnNow(sid,month,day,year);
    }

    public void addOff(Attendance attendance) {
        attendanceMapper.addOff(attendance);
    }

    public List<Attendance> getAByStaff(Staff staff) {
        return attendanceMapper.getAByStaff(staff);
    }


    public List<Attendance> getAByStaffMonth(int sid, int month) {
        return attendanceMapper.getAByStaffMonth(sid,month);
    }

    public List<Attendance> getAByStaffPage(int sid, int begin, int end) {
        return attendanceMapper.getAByStaffPage(sid,begin,end);
    }

    public int aSize(int sid, int month, int year) {
        return attendanceMapper.aSize(sid,month,year);
    }

    public List<Attendance> getAByStaffDate(int sid, int month, int year) {
        return attendanceMapper.getAByStaffDate(sid,month,year);
    }


}
