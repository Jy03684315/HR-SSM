package com.show.controller;

import com.show.model.*;
import com.show.service.DepartmentService;
import com.show.service.StaffService;
import com.show.service.StoTService;
import com.show.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/8/2.
 */
@Controller
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private StoTService stoTService;
    @Resource
    private StaffService staffService;
    @RequestMapping("/addTrain")
    public String addTrain(){
        return "addTrain";
    }
    @RequestMapping("/addTrain1")
    public String addTrain1(HttpSession session,Model model,Train train,String beginT,String endT) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = df.parse(beginT);
        Date end = df.parse(endT);
        Date date=new Date();
        train.setBegin(begin);
        train.setEnd(end);
        train.setTime(date);
        train.setState(0);
        session.setAttribute("t",train);
        List<Department> departments=departmentService.getDpAll();
        model.addAttribute("departments",departments);
        return "addTrain1";
    }
    @RequestMapping("/addTrainD")
    public String addTrainD(Department department,HttpSession session,Model model){
        Department department1=departmentService.getDpByIdALLS(department);
        if (department1==null){
            model.addAttribute("fail","该部门下没有员工");
            return addTrain();
        }
        List<Staff> staff=new ArrayList<Staff>();
        List<Position> positions=department1.getPositions();
        for (Position position : positions) {
            staff.addAll(position.getStaff());
        }
        Train train= (Train) session.getAttribute("t");
        trainService.addTrain(train);
        int tid=train.getId();
        Train train1=new Train(tid);
        for (int i=0;i<staff.size();i++){
            StoT stoT=new StoT();
            stoT.setTrain(train1);
            stoT.setStaff(staff.get(i));
            stoTService.addStoT(stoT);
        }
        return "redirect:staffManage";
    }
    @RequestMapping("/addTrainS")
    public String addTrainS(HttpSession session){
        List<Staff> staff=staffService.getStaffD();
        List<Staff> staffs=new ArrayList<Staff>();
        for (Staff staff1:staff) {
            Date date=new Date();
            if(((date.getTime()-staff1.getDate().getTime())/(1000*60*60*24))<7){
                staffs.add(staff1);
            }
        }
        Train train= (Train) session.getAttribute("t");
        trainService.addTrain(train);
        int tid=train.getId();
        Train train1=new Train(tid);
        for (int i=0;i<staffs.size();i++){
            StoT stoT=new StoT();
            stoT.setTrain(train1);
            stoT.setStaff(staffs.get(i));
            stoTService.addStoT(stoT);
        }
        return "redirect:staffManage";
    }
    @RequestMapping("/offTrain")
    public String offTrain(Model model){
        int state=0;
        List<Train> trains=trainService.getTrainByState(state);
        model.addAttribute("trains",trains);
        return "offTrain";
    }
    @RequestMapping("/onTrain")
    public String onTrain(Model model){
        int state=1;
        List<Train> trains=trainService.getTrainByState(state);
        model.addAttribute("trains",trains);
        return "onTrain";
    }
    @RequestMapping("/deliverT")
    public String deliverT(Train train,Model model){
        train.setState(1);
        trainService.changeState(train);
        return offTrain(model);
    }
    @RequestMapping("/toUpdateT")
    public String toUpdateT(Train train,Model model){
        Train train1=trainService.getTrainById(train);
        model.addAttribute("t",train1);
        return "updateTrain";
    }
    @RequestMapping("/updateT")
    public String updateT(Model model,Train train,String beginT,String endT) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = df.parse(beginT);
        Date end = df.parse(endT);
        train.setBegin(begin);
        train.setEnd(end);
        trainService.updateTrain(train);
        return offTrain(model);
    }
    @RequestMapping("/tBack")
    public String tBack(Train train,Model model){
        Train train1=trainService.getTrainById(train);
        Date date=new Date();
        long t=train1.getTime().getTime();
        long now=date.getTime();
        if (((now-t)/(1000*60))>10){
            model.addAttribute("fail","发布超过十分钟无法撤回");
            return onTrain(model);
        }
        train.setState(0);
        trainService.changeState(train);
        return onTrain(model);
    }
}
