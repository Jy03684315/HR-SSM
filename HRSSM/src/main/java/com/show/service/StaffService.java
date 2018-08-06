package com.show.service;

import com.show.model.Staff;

import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
public interface StaffService {
    void addStaff(Staff staff);
    List<Staff> getStaffD();
    Staff getStaffByNamePass(Staff staff);
    void updateStaff(Staff staff);
    Staff getStaffById(Staff staff);
    void toLeave(Staff staff);
    void changeState(Staff staff);
    void changeP(int pid,int sid);
}
