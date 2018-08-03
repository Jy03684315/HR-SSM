package com.show.dao;

import com.show.model.Reward;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/8/3.
 */
@Repository
public interface RewardMapper {
    void addReward(Reward reward);
    List<Reward> getReward();
    List<Reward> getRewardByPage(int begin,int end);
    void deleteReward(Reward reward);
    Reward getRewardById(Reward reward);
    void updateReward(Reward reward);
}
