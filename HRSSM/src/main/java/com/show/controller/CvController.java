package com.show.controller;

import com.show.model.Cv;
import com.show.model.Recruit;
import com.show.model.User;
import com.show.service.CvService;
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
 * Created by Show on 2018/7/26.
 */
@Controller
public class CvController {
    @Resource
    private CvService cvService;
    @RequestMapping("/CvList")
    public String getCv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, HttpSession session, Model model){
        User user= (User) session.getAttribute("u");
        List<Cv> cvs=cvService.getCv(user);
        if (cvs.size()==0){
            model.addAttribute("noCv","没有简历信息,请先添加简历");
            return "addCv";
        }
        int totalNum=cvs.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cv> cvList=cvService.getCvByPage(user.getId(),begin,end);
        model.addAttribute("cvs",cvList);
        model.addAttribute("totalPages",totalPages);
        return "listCv";
    }
    @RequestMapping("/toAddCv")
    public String toAddCv(){
        return "addCv";
    }
    @RequestMapping("/addCv")
    public String addCv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session,Model model,Cv cv,String birthday) throws ParseException {
        User user= (User) session.getAttribute("u");
        cv.setUser(user);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = df.parse(birthday);
        cv.setBirth(birth);
        cvService.addCv(cv);
        return getCv(currentPage,session,model);
    }
    @RequestMapping("/deleteCv")
    public String deleteCv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session,Model model,Cv cv){
        cvService.deleteCv(cv);
        return getCv(currentPage,session,model);
    }
    @RequestMapping("/cvDetail")
    public String cvDetail(Cv cv,Model model){
        Cv cv1=cvService.getCvById(cv);
        model.addAttribute("cv",cv1);
        return "CvDetail";
    }
    @RequestMapping("/toUpdateCv")
    public String toUpdateCv(Cv cv,Model model){
        Cv cv1=cvService.getCvById(cv);
        model.addAttribute("cv",cv1);
        return "updateCv";
    }
    @RequestMapping("/updateCv")
    public String updateCv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session,Model model,Cv cv,String birthday) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = df.parse(birthday);
        cv.setBirth(birth);
        cvService.updateCv(cv);
        return getCv(currentPage,session,model);
    }
    @RequestMapping("/deliverCv")
    public String deliverCv(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,Recruit recruit, HttpSession session,Model model){
        session.setAttribute("r",recruit);
        User user= (User) session.getAttribute("u");
        List<Cv> cvs=cvService.getCv(user);
        if (cvs.size()==0){
            model.addAttribute("noCv","没有简历信息,请先添加简历");
            return "addCv";
        }
        int totalNum=cvs.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Cv> cvList=cvService.getCvByPage(user.getId(),begin,end);
        model.addAttribute("cvs",cvList);
        model.addAttribute("totalPages",totalPages);
        return "choseCv";
    }
}
