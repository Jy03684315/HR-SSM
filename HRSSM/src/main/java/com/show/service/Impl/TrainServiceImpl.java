package com.show.service.Impl;

import com.show.dao.TrainMapper;
import com.show.model.Staff;
import com.show.model.Train;
import com.show.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/8/2.
 */
@Service
public class TrainServiceImpl implements TrainService{
    @Resource
    private TrainMapper trainMapper;

    public void addTrain(Train train) {
        trainMapper.addTrain(train);
    }

    public List<Train> getTrainByState(int state) {
        return trainMapper.getTrainByState(state);
    }

    public void changeState(Train train) {
        trainMapper.changeState(train);
    }

    public Train getTrainById(Train train) {
        return trainMapper.getTrainById(train);
    }

    public void updateTrain(Train train) {
        trainMapper.updateTrain(train);
    }

    public List<Train> getTrainByStateStaff(int state, int sid) {
        return trainMapper.getTrainByStateStaff(state,sid);
    }

    public List<Train> getTrainByStateStaffPage(int state, int sid, int begin, int end) {
        return trainMapper.getTrainByStateStaffPage(state,sid,begin,end);
    }

    public List<Train> getTrainByStaff(Staff staff) {
        return trainMapper.getTrainByStaff(staff);
    }

    public List<Train> getTrainByStaffPage(int sid, int begin, int end) {
        return trainMapper.getTrainByStaffPage(sid,begin,end);
    }

}
