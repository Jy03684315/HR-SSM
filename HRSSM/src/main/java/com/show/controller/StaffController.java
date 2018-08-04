package com.show.controller;

import com.show.model.Department;
import com.show.model.Interview;
import com.show.model.Position;
import com.show.model.Staff;
import com.show.service.DepartmentService;
import com.show.service.InterviewService;
import com.show.service.PositionService;
import com.show.service.StaffService;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private PositionService positionService;
    @Resource
    private DepartmentService departmentService;
    @RequestMapping("/addStaff")
    public String addStaff(Staff staff, HttpSession session){
        Staff staff1= (Staff) session.getAttribute("s");
        Interview interview= (Interview) session.getAttribute("i");
        staff1.setName(staff.getName());
        staff1.setPass(staff.getPass());
        interview.setState(4);
        interviewService.changeState(interview);
        staffService.addStaff(staff1);
        return "managerConsole";
    }
    @RequestMapping("/staffManage")
    public String staffManage(){
        return "staffManage";
    }
    @RequestMapping("/selectS")
    public String selectS(String selectP, HttpSession session){
        int pid= Integer.parseInt(selectP);
        if (pid==0){
            return "forward:rewardManage";
        }
        Position position=new Position(pid);
        Position position1=positionService.getPositionByIdS(position);
        List<Staff> staff=position1.getStaff();
        session.setAttribute("staff",staff);
        return "forward:rewardManage";
    }
    @RequestMapping("/toSLogin")
    public String toSLogin(){
        return "loginStaff";
    }
    @RequestMapping("/sLogin")
    public String sLogin(Staff staff, HttpSession session, Model model){
        Staff staff1=staffService.getStaffByNamePass(staff);
        if (staff1==null){
            model.addAttribute("failSL","用户名或密码错误");
            return "loginStaff";
        }
        session.setAttribute("s",staff1);
        return "staffConsole";
    }
    @RequestMapping("/dpsForS")
    public String dpsForS(Model model){
        List<Department> departments=departmentService.getDpAll();
        model.addAttribute("departments",departments);
        return "dpsForS";
    }
    @RequestMapping("/selectS1")
    public String selectS1(String selectP, HttpSession session){
        System.out.println(selectP);
        int pid= Integer.parseInt(selectP);
        if (pid==0){
            return "forward:dpsForS";
        }
        Position position=new Position(pid);
        Position position1=positionService.getPositionByIdS(position);
        if (position1==null){
            session.removeAttribute("staff");
            return "forward:dpsForS";
        }
        List<Staff> staff=position1.getStaff();
        session.setAttribute("staff",staff);
        return "forward:dpsForS";
    }
}
