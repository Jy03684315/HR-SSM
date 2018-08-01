package com.show.service;

import com.show.model.Cv;
import com.show.model.User;

import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
public interface CvService {
    List<Cv> getCv(User user);
    List<Cv> getCvByPage(int uid,int begin,int end);
    void addCv(Cv cv);
    void deleteCv(Cv cv);
    Cv getCvById(Cv cv);
    void updateCv(Cv cv);
}
