package com.show.controller;

import com.show.model.Cv;
import com.show.model.Interview;
import com.show.model.Recruit;
import com.show.model.User;
import com.show.service.InterviewService;
import com.show.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/7/30.
 */
@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;
    @RequestMapping("/addInterview")
    public String addInterview(Cv cv, HttpSession session){
        Recruit recruit= (Recruit) session.getAttribute("r");
        Interview interview=new Interview(0,cv,recruit);
        interviewService.addInterview(interview);
        return "successDelivery";
    }
    @RequestMapping("/unRead")
    public String unRead(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=0;
        List<Interview> interviews=interviewService.getInterviewByState(state);
        int totalNum=interviews.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews1=interviewService.getInterviewByStateAndPage(state,begin,end);
        System.out.println(interviews1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("interviews",interviews1);
        return "unReadInterview";
    }
    @RequestMapping("/itvDetail")
    public String itvDetail(Model model,Interview interview){
        Interview interview1=interviewService.getInterviewById(interview);
        if (interview1.getState()==0){
            interview1.setState(1);
            interviewService.changeState(interview1);
        }
        model.addAttribute("i",interview1);
        return "itvDetail";
    }
    @RequestMapping("/isRead")
    public String isRead(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=1;
        List<Interview> interviews=interviewService.getInterviewByState(state);
        int totalNum=interviews.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews1=interviewService.getInterviewByStateAndPage(state,begin,end);
        System.out.println(interviews1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("interviews",interviews1);
        return "isReadInterview";
    }
    @RequestMapping("/agreeItv")
    public String agreeItv(Interview interview){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setState(2);
        Date time;
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 3);
        time=ca.getTime();
        interview1.setTime(time);
        interviewService.updateInterview(interview1);
        return "managerConsole";
    }
    @RequestMapping("/forReply")
    public String forReply(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=2;
        List<Interview> interviews=interviewService.getInterviewByState(state);
        int totalNum=interviews.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews1=interviewService.getInterviewByStateAndPage(state,begin,end);
        System.out.println(interviews1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("interviews",interviews1);
        return "forReply";
    }
    @RequestMapping("/employment")
    public String employment(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=3;
        List<Interview> interviews=interviewService.getInterviewByState(state);
        int totalNum=interviews.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews1=interviewService.getInterviewByStateAndPage(state,begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("interviews",interviews1);
        return "employment";
    }
    @RequestMapping("/checkItv")
    public String checkItv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,HttpSession session){
        int state=2;
        User user= (User) session.getAttribute("u");
        int uid=user.getId();
        List<Interview> interviews=interviewService.getInterviewByStateU(uid,state);
        int totalNum=interviews.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Interview> interviews1=interviewService.getInterviewByStateUAndPage(uid,state,begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("interviews",interviews1);
        return "checkItv";
    }
    @RequestMapping("/acceptItv")
    public String acceptItv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,HttpSession session,Interview interview){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setState(3);
        interviewService.changeState(interview1);
        return checkItv(currentPage, model, session);
    }
    @RequestMapping("/refuseItv")
    public String refuseItv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,HttpSession session,Interview interview){
        Interview interview1=interviewService.getInterviewById(interview);
        interview1.setState(5);
        interviewService.changeState(interview1);
        return checkItv(currentPage, model, session);
    }
}
