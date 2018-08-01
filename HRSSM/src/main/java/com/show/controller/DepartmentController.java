package com.show.controller;

import com.show.dao.DepartmentMapper;
import com.show.service.DepartmentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/7/26.
 */
@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
}
