package com.show.service.Impl;

import com.show.dao.RecruitMapper;
import com.show.model.Recruit;
import com.show.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
@Service
public class RecruitServiceImpl implements RecruitService{
    @Resource
    private RecruitMapper recruitMapper;

    public List<Recruit> getRecruit(int state) {
        return recruitMapper.getRecruit(state);
    }

    public List<Recruit> getRecruitByStateAndPage(int state, int begin, int end) {
        return recruitMapper.getRecruitByStateAndPage(state,begin,end);
    }

    public void changeState(Recruit recruit) {
        recruitMapper.changeState(recruit);
    }

    public Recruit getRecruitById(Recruit recruit) {
        return recruitMapper.getRecruitById(recruit);
    }

    public void deleteRecruit(Recruit recruit) {
        recruitMapper.deleteRecruit(recruit);
    }

    public void addRecruit(Recruit recruit) {
        recruitMapper.addRecruit(recruit);
    }

    public void updateRecruit(Recruit recruit) {
        recruitMapper.updateRecruit(recruit);
    }
}
