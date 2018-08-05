package com.show.dao;

import com.show.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
@Repository
public interface StaffMapper {
    void addStaff(Staff staff);
    List<Staff> getStaffD();
    Staff getStaffByNamePass(Staff staff);
    void updateStaff(Staff staff);
    Staff getStaffById(Staff staff);
    void toLeave(Staff staff);
}
