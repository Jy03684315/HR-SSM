package com.show.service;

import com.show.model.Interview;

import java.util.List;

/**
 * Created by Show on 2018/7/30.
 */
public interface InterviewService {
    void addInterview(Interview interview);
    List<Interview> getInterviewByState(int state);
    List<Interview> getInterviewByStateAndPage(int state,int begin,int end);
    Interview getInterviewById(Interview interview);
    void changeState(Interview interview);
    void updateInterview(Interview interview);
    List<Interview> getInterviewByStateU(int uid,int state);
    List<Interview> getInterviewByStateUAndPage(int uid,int state,int begin,int end);
}
