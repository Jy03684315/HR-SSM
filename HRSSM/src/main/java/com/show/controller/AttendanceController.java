package com.show.controller;

import com.show.model.Attendance;
import com.show.model.Staff;
import com.show.service.AttendanceService;
import com.show.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/8/4.
 */
@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;
    @RequestMapping("/onTime")
    public String onTime(HttpSession session,Model model){
        Staff staff= (Staff) session.getAttribute("s");
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        Attendance attendance=attendanceService.getOnNow(staff.getId(),month, day);
        if (attendance!=null){
            model.addAttribute("isOn","上班已打卡，请勿重复打卡");
            return "staffConsole";
        }
        Attendance attendance1=new Attendance(date,month,day,staff);
        attendanceService.addOn(attendance1);
        model.addAttribute("sOn","上班打卡成功！");
        return "staffConsole";
    }
    @RequestMapping("/offTime")
    public String offTime(HttpSession session,Model model){
        Staff staff= (Staff) session.getAttribute("s");
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        Attendance attendance=attendanceService.getOnNow(staff.getId(),month, day);
        if (attendance==null){
            model.addAttribute("noOn","上班未打卡，请先上班打卡");
            return "staffConsole";
        }
        attendance.setOffTime(date);
        attendanceService.addOff(attendance);
        model.addAttribute("sOff","下班打卡成功！");
        return "staffConsole";
    }
    @RequestMapping("/attendanceInS")
    public String attendanceInS(@RequestParam(value = "month",defaultValue = "0")int month,Model model, HttpSession session){
        Staff staff= (Staff) session.getAttribute("s");
        Calendar calendar=Calendar.getInstance();
        if (month==0){
            List<Attendance> attendances=attendanceService.getAByStaffMonth(staff.getId(),calendar.get(Calendar.MONTH)+1);
            model.addAttribute("attendances",attendances);
            return "attendanceInS";
        }
        List<Attendance> attendances=attendanceService.getAByStaffMonth(staff.getId(),month);
        model.addAttribute("attendances",attendances);
        return "attendanceInS";
    }
    @RequestMapping("/toSAttendanceByM")
    public String toSAttendanceByM(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session,Model model,Staff staff){
        session.setAttribute("s",staff);
        return sAttendanceByM(currentPage,session,model);
    }
    @RequestMapping("/sAttendanceByM")
    public String sAttendanceByM(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session, Model model){
        Staff staff= (Staff) session.getAttribute("s");
        List<Attendance> attendances=attendanceService.getAByStaff(staff);
        int totalNum=attendances.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Attendance> attendances1=attendanceService.getAByStaffPage(staff.getId(),begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("attendances",attendances1);
        return "sAttendanceByM";
    }
}
