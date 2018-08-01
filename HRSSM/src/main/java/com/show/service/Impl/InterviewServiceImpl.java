package com.show.service.Impl;

import com.show.dao.InterviewMapper;
import com.show.model.Interview;
import com.show.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/7/30.
 */
@Service
public class InterviewServiceImpl implements InterviewService{
    @Resource
    private InterviewMapper interviewMapper;

    public void addInterview(Interview interview) {
        interviewMapper.addInterview(interview);
    }

    public List<Interview> getInterviewByState(int state) {
        return interviewMapper.getInterviewByState(state);
    }

    public List<Interview> getInterviewByStateAndPage(int state, int begin, int end) {
        return interviewMapper.getInterviewByStateAndPage(state,begin,end);
    }

    public Interview getInterviewById(Interview interview) {
        return interviewMapper.getInterviewById(interview);
    }

    public void changeState(Interview interview) {
        interviewMapper.changeState(interview);
    }

    public void updateInterview(Interview interview) {
        interviewMapper.updateInterview(interview);
    }

    public List<Interview> getInterviewByStateU(int uid, int state) {
        return interviewMapper.getInterviewByStateU(uid,state);
    }

    public List<Interview> getInterviewByStateUAndPage(int uid, int state, int begin, int end) {
        return interviewMapper.getInterviewByStateUAndPage(uid,state,begin,end);
    }
}
