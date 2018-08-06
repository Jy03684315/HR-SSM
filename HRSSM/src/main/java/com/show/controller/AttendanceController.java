package com.show.controller;

import com.show.model.Attendance;
import com.show.model.Reward;
import com.show.model.Staff;
import com.show.service.AttendanceService;
import com.show.service.RewardService;
import com.show.service.StaffService;
import com.show.utils.*;
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
    @Resource
    private StaffService staffService;
    @Resource
    private RewardService rewardService;
    @RequestMapping("/onTime")
    public String onTime(HttpSession session,Model model){
        Staff staff= (Staff) session.getAttribute("s");
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        int year=cal.get(Calendar.YEAR);
        Attendance attendance=attendanceService.getOnNow(staff.getId(),month, day,year);
        if (attendance!=null){
            model.addAttribute("isOn","�ϰ��Ѵ򿨣������ظ���");
            return "staffConsole";
        }
        Attendance attendance1=new Attendance(date,month,day,year,staff);
        attendanceService.addOn(attendance1);
        model.addAttribute("sOn","�ϰ�򿨳ɹ���");
        return "staffConsole";
    }
    @RequestMapping("/offTime")
    public String offTime(HttpSession session,Model model){
        Staff staff= (Staff) session.getAttribute("s");
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        int year=cal.get(Calendar.YEAR);
        Attendance attendance=attendanceService.getOnNow(staff.getId(),month, day,year);
        if (attendance==null){
            model.addAttribute("noOn","�ϰ�δ�򿨣������ϰ��");
            return "staffConsole";
        }
        attendance.setOffTime(date);
        attendanceService.addOff(attendance);
        model.addAttribute("sOff","�°�򿨳ɹ���");
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
    @RequestMapping("/accountA")
    public String accountA(){
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        List<Staff> staffs=staffService.getStaffD();
        List<Staff> lessStaffs=new ArrayList<Staff>();
        List<Staff> moreStaffs=new ArrayList<Staff>();
        for (Staff staff:staffs) {
            int count=attendanceService.aSize(staff.getId(),month,year);
            if (count<22){
                lessStaffs.add(staff);//�򿨵���22��
            }else {
                moreStaffs.add(staff);//�򿨴��ڵ���22��
            }
        }
        for (Staff staff:lessStaffs){
            List<Attendance> attendances=attendanceService.getAByStaffDate(staff.getId(),month,year);
            int size=attendances.size();
            int day=22-size;
            rewardService.addReward(DoAbsenteeism.doAbsenteeism(staff,day));
            for (Attendance attendance:attendances){
                int onHour=attendance.getOnTime().getHours();
                if (attendance.getOffTime()==null){
                    rewardService.addReward(DoAbsenteeism.doAbsenteeism(staff,1));//û���°࿨�����
                }else {
                    int offHour=attendance.getOffTime().getHours();
                    int total=(onHour-9)+(17-offHour);
                    if ((onHour-9)>=3||(17-offHour)>=3||total>=3){
                        rewardService.addReward(DoAbsenteeism.doAbsenteeism(staff,1));//������Сʱ����
                    }else if (((onHour-9)>0&&(onHour-9)<3)||((17-offHour)>0&&(17-offHour)<3)||(total>0&&total<3)){
                        rewardService.addReward(DoLate.doLate(staff));//��������Сʱ��򿨳ٵ�
                    }
                    if (offHour-17>=1){
                        rewardService.addReward(DoOvertime.doOvertime(staff,offHour-17));//�����°�ʱ��һСʱ���ϼӰ�
                    }
                }
            }
        }
        for (Staff staff:moreStaffs){
            List<Attendance> attendances=attendanceService.getAByStaffDate(staff.getId(),month,year);
            int size=attendances.size();
            int day=size-22;
            rewardService.addReward(DoOvertimeByDay.doOvertimeByDay(staff,day));//����22��Ĳ��ְ�ÿ������������Ӱ�ѣ���һ���ٵ��Ϳ������ǰ����洦��
            for (Attendance attendance:attendances){
                int onHour=attendance.getOnTime().getHours();
                if (attendance.getOffTime()==null){
                    rewardService.addReward(DoAbsenteeism.doAbsenteeism(staff,1));//û���°࿨�����
                }else {
                    int offHour=attendance.getOffTime().getHours();
                    int total=(onHour-9)+(17-offHour);
                    if ((onHour-9)>=3||(17-offHour)>=3||total>=3){
                        rewardService.addReward(DoAbsenteeism.doAbsenteeism(staff,1));//������Сʱ����
                    }else if (((onHour-9)>0&&(onHour-9)<3)||((17-offHour)>0&&(17-offHour)<3)||(total>0&&total<3)){
                        rewardService.addReward(DoLate.doLate(staff));//��������Сʱ��򿨳ٵ�
                    }
                    if (offHour-17>=1){
                        rewardService.addReward(DoOvertime.doOvertime(staff,offHour-17));//�����°�ʱ��һСʱ���ϼӰ�
                    }
                }
            }
        }
        return "managerConsole";
    }
}
