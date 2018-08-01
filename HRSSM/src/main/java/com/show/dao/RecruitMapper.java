package com.show.dao;

import com.show.model.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
@Repository
public interface RecruitMapper {
    List<Recruit> getRecruit(int state);
    List<Recruit> getRecruitByStateAndPage(int state,int begin,int end);
    void changeState(Recruit recruit);
    Recruit getRecruitById(Recruit recruit);
    void deleteRecruit(Recruit recruit);
    void addRecruit(Recruit recruit);
    void updateRecruit(Recruit recruit);
}
