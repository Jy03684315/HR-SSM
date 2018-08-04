package com.show.service;

import com.show.model.Attendance;
import com.show.model.Staff;

/**
 * Created by Show on 2018/8/4.
 */
public interface AttendanceService {
    void  addOn(Attendance attendance);
    Attendance getOnNow(int sid,int month,int day);
    void addOff(Attendance attendance);
}
