package com.show.service;

import com.show.model.Attendance;
import com.show.model.Staff;

import java.util.List;

/**
 * Created by Show on 2018/8/4.
 */
public interface AttendanceService {
    void  addOn(Attendance attendance);
    Attendance getOnNow(int sid,int month,int day,int year);
    void addOff(Attendance attendance);
    List<Attendance> getAByStaff(Staff staff);
    List<Attendance> getAByStaffMonth(int sid,int month);
    List<Attendance> getAByStaffPage(int sid,int begin,int end);
    int aSize(int sid,int month,int year);
    List<Attendance> getAByStaffDate(int sid,int month,int year);
}
