package com.show.utils;

import com.show.model.Reward;
import com.show.model.Staff;

import java.util.Date;

/**
 * Created by Show on 2018/8/6.
 */
public class DoOvertimeByDay {
    public static Reward doOvertimeByDay(Staff staff, int day){
        Date date=new Date();
        Reward reward=new Reward();
        reward.setDate(date);
        reward.setStaff(staff);
        reward.setMoney(staff.getPosition().getSalary()/22*day);
        reward.setExplain("¼Ó°à");
        return  reward;
    }
}
