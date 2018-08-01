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
}
