package com.show.dao;

import com.show.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Repository
public interface DepartmentMapper {
    List<Department> getDp();
    Department getDpById(Department department);
    void addDp(Department department);
    List<Department> getDpAll();
    Department getDpByName(Department department);
    Department getDpByIdALL(Department department);
    void updateDp(Department department);
    void deleteDp(Department department);
    Department getDpByIdALLS(Department department);
    List<Department> getDpPS();
}
