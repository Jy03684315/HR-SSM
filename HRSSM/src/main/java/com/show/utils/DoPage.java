package com.show.utils;

/**
 * Created by Show on 2018/7/27.
 */
public class DoPage {
    private static final int PAGESIZE = 5;

    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE :totalRows/PAGESIZE + 1;
    }
}