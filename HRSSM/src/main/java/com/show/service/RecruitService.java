package com.show.service;

import com.show.model.Recruit;

import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
public interface RecruitService {
    List<Recruit> getRecruit(int state);
    List<Recruit> getRecruitByStateAndPage(int state,int begin,int end);
    void changeState(Recruit recruit);
    Recruit getRecruitById(Recruit recruit);
    void deleteRecruit(Recruit recruit);
    void addRecruit(Recruit recruit);
    void updateRecruit(Recruit recruit);
}
