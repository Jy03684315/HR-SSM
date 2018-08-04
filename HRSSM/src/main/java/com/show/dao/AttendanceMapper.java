package com.show.dao;

import com.show.model.Attendance;
import com.show.model.Staff;
import org.springframework.stereotype.Repository;

/**
 * Created by Show on 2018/8/4.
 */
@Repository
public interface AttendanceMapper {
    void  addOn(Attendance attendance);
    Attendance getOnNow(int sid,int month,int day);
    void addOff(Attendance attendance);
}
