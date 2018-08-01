package com.show.dao;

import com.show.model.Interview;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/7/30.
 */
@Repository
public interface InterviewMapper {
    void addInterview(Interview interview);
    List<Interview> getInterviewByState(int state);
    List<Interview> getInterviewByStateAndPage(int state,int begin,int end);
    List<Interview> getInterviewByStateU(int uid,int state);
    List<Interview> getInterviewByStateUAndPage(int uid,int state,int begin,int end);
    Interview getInterviewById(Interview interview);
    void changeState(Interview interview);
    void updateInterview(Interview interview);
}
