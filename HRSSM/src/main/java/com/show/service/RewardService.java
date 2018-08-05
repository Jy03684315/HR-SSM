package com.show.service;

import com.show.model.Reward;
import com.show.model.Staff;

import java.util.List;

/**
 * Created by Show on 2018/8/3.
 */
public interface RewardService {
    void addReward(Reward reward);
    List<Reward> getReward();
    List<Reward> getRewardByPage(int begin,int end);
    void deleteReward(Reward reward);
    Reward getRewardById(Reward reward);
    void updateReward(Reward reward);
    List<Reward> getRewardByStaff(Staff staff);
}
