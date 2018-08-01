package com.show.service;

import com.show.model.Department;

import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
public interface DepartmentService {
    List<Department> getDp();
    Department getDpById(Department department);
    void addDp(Department department);
    List<Department> getDpAll();
    Department getDpByName(Department department);
    Department getDpByIdALL(Department department);
    void updateDp(Department department);
    Department getDpByIdALLS(Department department);
    void deleteDp(Department department);
}
