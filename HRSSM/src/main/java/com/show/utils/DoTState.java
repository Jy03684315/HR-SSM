package com.show.utils;

/**
 * Created by Show on 2018/8/6.
 */
public class DoTState {
    public static String getTState(int state){
        switch (state){
            case 0:
                return "未发布";
            case 1:
                return "已发布";
        }
        return "未定义";
    }
}
