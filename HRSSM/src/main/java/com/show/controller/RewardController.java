package com.show.controller;

import com.show.model.Department;
import com.show.model.Reward;
import com.show.model.Staff;
import com.show.service.DepartmentService;
import com.show.service.RewardService;
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
 * Created by Show on 2018/8/3.
 */
@Controller
public class RewardController {
    @Resource
    private RewardService rewardService;
    @Resource
    private DepartmentService departmentService;
    @RequestMapping("/rewardManage")
    public String rewardManage(Model model){
        List<Department> departments=departmentService.getDpPS();
        model.addAttribute("departments",departments);
        return "rewardManage";
    }
    @RequestMapping("/addReward")
    public String addReward(Staff staff, HttpSession session){
        Reward reward=new Reward();
        reward.setStaff(staff);
        session.setAttribute("r",reward);
        return "addReward";
    }
    @RequestMapping("/addReward1")
    public String addReward1(Reward reward, HttpSession session,Model model){
        Reward r= (Reward) session.getAttribute("r");
        reward.setStaff(r.getStaff());
        Date date=new Date();
        reward.setDate(date);
        rewardService.addReward(reward);
        return rewardManage(model);
    }
    @RequestMapping("/getReward")
    public String getReward(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,Model model){
        List<Reward> rewards=rewardService.getReward();
        int totalNum=rewards.size();
        int pageSize=5;
        int totalPages= DoPage.getTotalPages(totalNum);
        int begin = (currentPage-1)*pageSize+1;
        int end = (currentPage-1)*pageSize+pageSize;
        List<Reward> rewardList=rewardService.getRewardByPage(begin,end);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("rewards",rewardList);
        return "listRewards";
    }
    @RequestMapping("/deleteReward")
    public String deleteReward(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,Model model,Reward reward){
        rewardService.deleteReward(reward);
        return getReward(currentPage,model);
    }
    @RequestMapping("/toUpdateReward")
    public String toUpdateReward(Reward reward,Model model){
        Reward reward1=rewardService.getRewardById(reward);
        model.addAttribute("r",reward1);
        return "updateReward";
    }
    @RequestMapping("/updateReward")
    public String updateReward(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,Model model,Reward reward){
        rewardService.updateReward(reward);
        return getReward(currentPage,model);
    }
    @RequestMapping("/rewardInS")
    public String rewardInS(@RequestParam(value = "month",defaultValue = "0")int month,HttpSession session,Model model){
        Staff staff= (Staff) session.getAttribute("s");
        List<Reward> rewards=rewardService.getRewardByStaff(staff);
        Calendar calendar=Calendar.getInstance();
        if (month==0){
            month=calendar.get(Calendar.MONTH)+1;
        }
        List<Reward> rewards1=new ArrayList<Reward>();
        for (Reward reward:rewards) {
            if ((reward.getDate().getMonth()+1)==month){
                rewards1.add(reward);
            }
        }
        model.addAttribute("rewards",rewards1);
        return "rewardInS";
    }
}
