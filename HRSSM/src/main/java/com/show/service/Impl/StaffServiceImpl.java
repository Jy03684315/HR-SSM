package com.show.service.Impl;

import com.show.dao.StaffMapper;
import com.show.model.Staff;
import com.show.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Resource
    private StaffMapper staffMapper;

    public void addStaff(Staff staff) {
        staffMapper.addStaff(staff);
    }

    public List<Staff> getStaffD() {
        return staffMapper.getStaffD();
    }

    public Staff getStaffByNamePass(Staff staff) {
        return staffMapper.getStaffByNamePass(staff);
    }
}
