package com.show.controller;

import com.show.model.Pay;
import com.show.model.Reward;
import com.show.model.Staff;
import com.show.service.PayService;
import com.show.service.RewardService;
import com.show.service.StaffService;
import com.show.utils.DoPage;
import com.sun.xml.internal.ws.message.stream.PayloadStreamReaderMessage;
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
 * Created by Show on 2018/8/7.
 */
@Controller
public class PayController {
    @Resource
    private PayService payService;
    @Resource
    private StaffService staffService;
    @Resource
    private RewardService rewardService;
    @RequestMapping("/accountPay")
    public String accountPay(Model model){
        Calendar cal = Calendar.getInstance();
        int day=cal.get(Calendar.DATE);
        if (day<5){
            model.addAttribute("cannotPay","请在五号之后结算薪资");
            return "managerConsole";
        }
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        List<Staff> staffs=staffService.getStaffD();
        for (Staff staff:staffs){
            Pay pay=new Pay();
            pay.setYear(year);
            pay.setMonth(month);
            pay.setStaff(staff);
            pay.setBase(staff.getPosition().getSalary());
            pay.setBonus((int) (staff.getPosition().getSalary()*0.3));
            pay.setSs((int) (staff.getPosition().getSalary()*0.1));
            List<Reward> rewards=rewardService.getRewardByStaff(staff);
            for (Reward reward:rewards){
                if (reward.getDate().getMonth()+1==month){
                    if (reward.getExplain().equals("加班")){
                        pay.setOv(pay.getOv()+reward.getMoney());
                    }else {
                        pay.setRew(pay.getRew()+reward.getMoney());
                    }
                }
            }
            payService.addPay(pay);
        }
        return "managerConsole";
    }
    @RequestMapping("/payInS")
    public String payInS(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session, Model model){
        Staff staff= (Staff) session.getAttribute("s");
        List<Pay> pays=payService.getPayByStaff(staff);
        int totalNum=pays.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays1=payService.getPayByStaffPage(staff.getId(),begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("pays",pays1);
        return "payInS";
    }
    @RequestMapping("/reconsideration")
    public String reconsideration(Pay pay){
        pay.setState(1);
        payService.changeState(pay);
        return "staffConsole";
    }
    @RequestMapping("/toSPayByM")
    public String toSPayByM(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model, Staff staff, HttpSession session){
        session.setAttribute("s",staff);
        return sPayByM(currentPage,session,model);
    }
    @RequestMapping("/sPayByM")
    public String sPayByM(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,HttpSession session, Model model){
        Staff staff= (Staff) session.getAttribute("s");
        List<Pay> pays=payService.getPayByStaff(staff);
        int totalNum=pays.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays1=payService.getPayByStaffPage(staff.getId(),begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("pays",pays1);
        return "sPayByM";
    }
    @RequestMapping("/reconsiderationInM")
    public String reconsiderationInM(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model){
        int state=1;
        List<Pay> pays=payService.getPayByState(state);
        int totalNum=pays.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Pay> pays1=payService.getPayByStatePage(state,begin,end);
        System.out.println(pays1);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("pays",pays1);
        return "reconsiderationInM";
    }
    @RequestMapping("/agreeReconsideration")
    public String agreeReconsideration(int money,Pay pay){
        pay.setState(2);
        payService.changeStateOnly(pay);
        Reward reward=new Reward();
        Date date=new Date();
        reward.setDate(date);
        reward.setMoney(money);
        reward.setExplain("复议");
        Pay pay1=payService.getPayById(pay);
        reward.setStaff(pay1.getStaff());
        rewardService.addReward(reward);
        return "managerConsole";
    }
    @RequestMapping("/refuseReconsideration")
    public String refuseReconsideration(Pay pay){
        pay.setState(2);
        payService.changeStateOnly(pay);
        return "managerConsole";
    }
}
