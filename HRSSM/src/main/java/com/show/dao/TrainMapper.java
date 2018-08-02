package com.show.dao;

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
}
