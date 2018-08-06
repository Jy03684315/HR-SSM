package com.show.utils;

import com.show.model.Reward;
import com.show.model.Staff;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Date;

/**
 * Created by Show on 2018/8/6.
 */
public class DoOvertime {
    public static Reward doOvertime(Staff staff, int hour){
        Date date=new Date();
        Reward reward=new Reward();
        reward.setDate(date);
        reward.setStaff(staff);
        reward.setMoney(50*hour);
        reward.setExplain("¼Ó°à");
        return  reward;
    }
}
