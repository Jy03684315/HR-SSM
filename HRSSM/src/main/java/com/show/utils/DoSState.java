package com.show.utils;

/**
 * Created by Show on 2018/8/1.
 */
public class DoSState {
    public static String getState(int state){
        switch (state){
            case 1:
                return "试用期";
            case 2:
                return "在职";
            case 3:
                return "离职";
        }
        return "未定义";
    }
}
