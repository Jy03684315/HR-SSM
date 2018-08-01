package com.show.controller;

import com.show.model.Position;
import com.show.model.Recruit;
import com.show.service.PositionService;
import com.show.service.RecruitService;
import com.show.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private PositionService positionService;
    @RequestMapping("/")
    public String listRecruit(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=1;
        List<Recruit> recruits=recruitService.getRecruit(state);
        int totalNum=recruits.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit> recruitList=recruitService.getRecruitByStateAndPage(state,begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("recruits",recruitList);
        return "../../login";
    }
    @RequestMapping("/logout")
    public String logout(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session, Model model){
        session.removeAttribute("u");
        return listRecruit(currentPage,model);
    }
    @RequestMapping("/ret")
    public String ret(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
       return listRecruit(currentPage,model);
    }
    @RequestMapping("/noRelease")
    public String noRelease(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=0;
        List<Recruit> recruits=recruitService.getRecruit(state);
        int totalNum=recruits.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit> recruitList=recruitService.getRecruitByStateAndPage(state,begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("recruits",recruitList);
        return "listRecruitNoR";
    }
    @RequestMapping("/isRelease")
    public String isRelease(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=1;
        List<Recruit> recruits=recruitService.getRecruit(state);
        int totalNum=recruits.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Recruit> recruitList=recruitService.getRecruitByStateAndPage(state,begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("recruits",recruitList);
        return "listRecruitIsR";
    }
    @RequestMapping("/changeState")
    public String changeState(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,Recruit recruit){
        recruit.setState(1);
        recruitService.changeState(recruit);
        return noRelease(currentPage,model);
    }
    @RequestMapping("/deleteRecruit")
    public String deleteRecruit(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,Recruit recruit){
        recruitService.deleteRecruit(recruit);
        return noRelease(currentPage,model);
    }
    @RequestMapping("/toAddRecruit")
    public String toAddRecruit(Model model){
        List<Position> positions=positionService.positionList();
        model.addAttribute("p",positions);
        return "addRecruit";
    }
    @RequestMapping("/addRecruit")
    public String addRecruit(@RequestParam int pid,Recruit recruit,String dateR) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateR);
        recruit.setDate(date);
        Position position=new Position(pid);
        recruit.setPosition(position);
        recruitService.addRecruit(recruit);
        return "managerConsole";
    }
    @RequestMapping("/toUpdateRecruit")
    public String toUpdateRecruit(Recruit recruit,Model model){
        List<Position> positions=positionService.positionList();
        model.addAttribute("p",positions);
        Recruit recruit1 = recruitService.getRecruitById(recruit);
        model.addAttribute("r",recruit1);
        return "updateRecruit";
    }
    @RequestMapping("/updateRecruit")
    public String updateRecruit(@RequestParam int pid,Recruit recruit,String dateR) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateR);
        recruit.setDate(date);
        Position position=new Position(pid);
        recruit.setPosition(position);
        recruitService.updateRecruit(recruit);
        return "managerConsole";
    }
    @RequestMapping("/changeState1")
    public String changeState1(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model,Recruit recruit){
        recruit.setState(0);
        recruitService.changeState(recruit);
        return isRelease(currentPage,model);
    }
}
