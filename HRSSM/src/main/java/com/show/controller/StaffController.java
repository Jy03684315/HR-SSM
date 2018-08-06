package com.show.controller;

import com.show.model.Department;
import com.show.model.Interview;
import com.show.model.Position;
import com.show.model.Staff;
import com.show.service.DepartmentService;
import com.show.service.InterviewService;
import com.show.service.PositionService;
import com.show.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping("/toStaffConsole")
    public String toStaffConsole(){
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
    @RequestMapping("/toUpdateSDetail")
    public String toUpdateSDetail(){
        return "updateSDetail";
    }
    @RequestMapping("/updateSDetail")
    public String updateSDetail(HttpSession session,Staff staff,String sBirth) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = df.parse(sBirth);
        staff.setBirth(birth);
        staffService.updateStaff(staff);
        Staff staff1= (Staff) session.getAttribute("s");
        staff1.setsName(staff.getsName());
        staff1.setSex(staff.getSex());
        staff1.setBirth(staff.getBirth());
        staff1.setIdCard(staff.getIdCard());
        staff1.setGraduation(staff.getGraduation());
        staff1.setEducation(staff.getEducation());
        staff1.setCertificate(staff.getCertificate());
        session.setAttribute("s",staff1);
        return toStaffConsole();
    }
    @RequestMapping("/probation")
    public String probation(Model model){
        int state=1;
        List<Department> departments=departmentService.getDpPS();
        model.addAttribute("departments",departments);
        model.addAttribute("state",state);
        return "doStaff";
    }
    @RequestMapping("/onJob")
    public String onJob(Model model){
        int state=2;
        List<Department> departments=departmentService.getDpPS();
        model.addAttribute("departments",departments);
        model.addAttribute("state",state);
        return "doStaff";
    }
    @RequestMapping("/leaveJob")
    public String leaveJob(Model model){
        int state=3;
        List<Department> departments=departmentService.getDpPS();
        model.addAttribute("departments",departments);
        model.addAttribute("state",state);
        return "doStaff";
    }
    @RequestMapping("/doProbation")
    public String doProbation(String selectP,Model model){
        int pid= Integer.parseInt(selectP);
        Position position=new Position(pid);
        Position position1=positionService.getPositionByIdS(position);
        List<Staff> staff=position1.getStaff();
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getState()!=1){
                staff.remove(staff.get(i));
            }
        }
        int state=1;
        model.addAttribute("state",state);
        model.addAttribute("staff",staff);
        return "doStaffList";
    }
    @RequestMapping("/sDetailByM")
    public String sDetailByM(Staff staff,Model model){
        Staff staff1=staffService.getStaffById(staff);
        model.addAttribute("s",staff1);
        return "sDetailByM";
    }
    @RequestMapping("/toLeave")
    public String toLeave(Staff staff,Model model){
        model.addAttribute("s",staff);
        return "toLeave";
    }
    @RequestMapping("/leave")
    public String leave(Staff staff){
        staff.setState(3);
        staffService.toLeave(staff);
        return staffManage();
    }
    @RequestMapping("/doOnJob")
    public String doOnJob(String selectP,Model model){
        int pid= Integer.parseInt(selectP);
        Position position=new Position(pid);
        Position position1=positionService.getPositionByIdS(position);
        List<Staff> staff=position1.getStaff();
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getState()!=2){
                staff.remove(staff.get(i));
            }
        }
        int state=2;
        model.addAttribute("state",state);
        model.addAttribute("staff",staff);
        return "doStaffList";
    }
    @RequestMapping("/doLeaveJob")
    public String doLeaveJob(String selectP,Model model){
        int pid= Integer.parseInt(selectP);
        Position position=new Position(pid);
        Position position1=positionService.getPositionByIdS(position);
        if (position1==null){
            model.addAttribute("fail","没有员工");
            return "staffManage";
        }
        List<Staff> staff=position1.getStaff();
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getState()!=3){
                staff.remove(staff.get(i));
            }
        }
        int state=3;
        model.addAttribute("state",state);
        model.addAttribute("staff",staff);
        return "doStaffList";
    }
    @RequestMapping("/beFull")
    public String beFull(Staff staff,Model model){
        Staff staff1=staffService.getStaffById(staff);
        Date date=staff1.getDate();
        Date now=new Date();
        long from=date.getTime();
        long to=now.getTime();
        int days= (int) ((to-from)/(1000*60*60*24));
        if (days<30){
            model.addAttribute("failBeFull","未满一个月，无法转正");
            return "staffManage";
        }
        staff1.setState(2);
        staffService.changeState(staff1);
        return "staffManage";
    }
    @RequestMapping("/changing")
    public String changing(Staff staff,HttpSession session,Model model){
        Staff staff1=staffService.getStaffById(staff);
        List<Department> departments=departmentService.getDpAll();
        session.setAttribute("s",staff1);
        model.addAttribute("departments",departments);
        return "changing";
    }
    @RequestMapping("/doChanging")
    public String doChanging(HttpSession session,String selectP,Model model){
        int pid= Integer.parseInt(selectP);
        if (pid==0){
            model.addAttribute("failChanging","请正确选择部门职位");
            return "staffManage";
        }
        Staff staff= (Staff) session.getAttribute("s");
        staffService.changeP(pid,staff.getId());
        return "staffManage";
    }
}
