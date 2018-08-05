package com.show.dao;

import com.show.model.Staff;
import com.show.model.Train;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/8/2.
 */
@Repository
public interface TrainMapper {
    void addTrain(Train train);
    List<Train> getTrainByState(int state);
    void  changeState(Train train);
    Train getTrainById(Train train);
    void updateTrain(Train train);
    List<Train> getTrainByStateStaff(int state,int sid);
    List<Train> getTrainByStateStaffPage(int state,int sid,int begin,int end);
    List<Train> getTrainByStaff(Staff staff);
    List<Train> getTrainByStaffPage(int sid,int begin,int end);
}
