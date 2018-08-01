package com.show.controller;

import com.show.dao.DepartmentMapper;
import com.show.model.Department;
import com.show.model.Position;
import com.show.model.Recruit;
import com.show.service.DepartmentService;
import com.show.service.PositionService;
import com.show.service.RecruitService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private RecruitService recruitService;
    @RequestMapping("/listDepartment")
    public String listDepartment(HttpSession session){
        List<Department> departments=departmentService.getDp();
        session.setAttribute("departments",departments);
        return "listDepartment";
    }
    @RequestMapping("/positionsInD")
    public @ResponseBody List<Position> positionsInD(Department department,HttpSession session){
        Department department1=departmentService.getDpById(department);
        List<Position> positions=department1.getPositions();
        return positions;
    }
    @RequestMapping("/addDepartment")
    public String addDepartment(Department department,HttpSession session,Model model){
        if (departmentService.getDpByName(department)!=null){
            model.addAttribute("fail","该部门已存在");
            return listDepartment(session);
        }
        Date date=new Date();
        department.setDate(date);
        departmentService.addDp(department);
        return listDepartment(session);
    }
    @RequestMapping("/doDepartment")
    public String doDepartment(Model model){
        List<Department> departments=departmentService.getDpAll();
        model.addAttribute("departments",departments);
        return "doDepartment";
    }
    @RequestMapping("/toUpdateDepartment")
    public String toUpdateDepartment(Department department,Model model){
        Department department1=departmentService.getDpByIdALL(department);
        model.addAttribute("d",department1);
        return "updateDepartment";
    }
    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(Department department,Model model){
        Department department1=departmentService.getDpByIdALL(department);
        Department department2=departmentService.getDpById(department);
        Department department3=departmentService.getDpByIdALLS(department);
        if (department2!=null&&department3!=null){
            model.addAttribute("fail","该部门下有职员，无法删除");
            return doDepartment(model);
        }
        if (department2!=null&&department3==null){
            List<Position> positions=department2.getPositions();
            for (Position position:positions){
                Position position1=positionService.getPositionByIdR(position);
                if (position1!=null){
                    List<Recruit> recruits=position1.getRecruit();
                    for (Recruit recruit:recruits){
                        recruitService.deleteRecruit(recruit);
                    }
                }
                positionService.deletePositionById(position);
            }
            departmentService.deleteDp(department1);
            return doDepartment(model);
        }
        departmentService.deleteDp(department1);
        return doDepartment(model);
    }
    @RequestMapping("/updateDepartment")
    public String updateDepartment(Department department,Model model){
        departmentService.updateDp(department);
        return doDepartment(model);
    }
}
