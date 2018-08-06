package com.show.utils;

import com.show.model.Reward;
import com.show.model.Staff;

import java.util.Date;

/**
 * Created by Show on 2018/8/6.
 */
public class DoLate {
    public static Reward doLate(Staff staff){
        Date date=new Date();
        Reward reward=new Reward();
        reward.setDate(date);
        reward.setStaff(staff);
        reward.setMoney(0-50);
        reward.setExplain("³Ùµ½");
        return reward;
    }
}
