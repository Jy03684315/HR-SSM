package com.show.service;

import com.show.model.Train;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/8/2.
 */
public interface TrainService {
    void addTrain(Train train);
    List<Train> getTrainByState(int state);
    void  changeState(Train train);
    Train getTrainById(Train train);
    void updateTrain(Train train);
    List<Train> getTrainByStateStaff(int state,int sid);
    List<Train> getTrainByStateStaffPage(int state,int sid,int begin,int end);
}
