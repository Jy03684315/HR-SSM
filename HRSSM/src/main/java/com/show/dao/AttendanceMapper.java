package com.show.dao;

import com.show.model.Attendance;
import com.show.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/8/4.
 */
@Repository
public interface AttendanceMapper {
    void  addOn(Attendance attendance);
    Attendance getOnNow(int sid,int month,int day);
    void addOff(Attendance attendance);
    List<Attendance> getAByStaff(Staff staff);
    List<Attendance> getAByStaffMonth(int sid,int month);
    List<Attendance> getAByStaffPage(int sid,int begin,int end);
}
