package com.show.service;

import com.show.model.Staff;

import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
public interface StaffService {
    void addStaff(Staff staff);
    List<Staff> getStaffD();
}