package com.show.service.Impl;

import com.show.dao.CvMapper;
import com.show.model.Cv;
import com.show.model.User;
import com.show.service.CvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
@Service
public class CvServiceImpl implements CvService{
    @Resource
    private CvMapper cvMapper;

    public List<Cv> getCv(User user) {
        return cvMapper.getCv(user);
    }

    public List<Cv> getCvByPage(int uid,int begin,int end) {
        return cvMapper.getCvByPage(uid,begin,end);
    }

    public void addCv(Cv cv) {
        cvMapper.addCv(cv);
    }

    public void deleteCv(Cv cv) {
        cvMapper.deleteCv(cv);
    }

    public Cv getCvById(Cv cv) {
        return cvMapper.getCvById(cv);
    }

    public void updateCv(Cv cv) {
        cvMapper.updateCv(cv);
    }
}
