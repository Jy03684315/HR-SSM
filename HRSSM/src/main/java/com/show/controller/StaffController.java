package com.show.controller;

import com.show.model.Interview;
import com.show.model.Staff;
import com.show.service.InterviewService;
import com.show.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Show on 2018/8/1.
 */
@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private InterviewService interviewService;
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
}
