package com.show.service.Impl;

import com.show.dao.DepartmentMapper;
import com.show.model.Department;
import com.show.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> getDp() {
        return departmentMapper.getDp();
    }

    public Department getDpById(Department department) {
        return departmentMapper.getDpById(department);
    }

    public void addDp(Department department) {
        departmentMapper.addDp(department);
    }

    public List<Department> getDpAll() {
        return departmentMapper.getDpAll();
    }

    public Department getDpByName(Department department) {
        return departmentMapper.getDpByName(department);
    }

    public Department getDpByIdALL(Department department) {
        return departmentMapper.getDpByIdALL(department);
    }

    public void updateDp(Department department) {
        departmentMapper.updateDp(department);
    }

    public Department getDpByIdALLS(Department department) {
        return departmentMapper.getDpByIdALLS(department);
    }

    public void deleteDp(Department department) {
        departmentMapper.deleteDp(department);
    }

    public List<Department> getDpPS() {
        return departmentMapper.getDpPS();
    }
}
