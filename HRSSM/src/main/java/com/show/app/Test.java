package com.show.app;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Show on 2018/8/6.
 */
public class Test {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date.getMonth());
        Calendar cal = Calendar.getInstance();
        int month=cal.get(Calendar.MONTH);
        System.out.println(month);
    }
}
