package com.show.utils;

/**
 * Created by Show on 2018/8/6.
 */
public class DoTState {
    public static String getTState(int state){
        switch (state){
            case 0:
                return "δ����";
            case 1:
                return "�ѷ���";
        }
        return "δ����";
    }
}
