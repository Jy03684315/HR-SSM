package com.show.controller;

import com.show.model.Attendance;
import com.show.model.Staff;
import com.show.service.AttendanceService;
import com.show.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

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
}
