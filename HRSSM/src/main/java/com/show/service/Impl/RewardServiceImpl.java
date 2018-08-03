package com.show.service.Impl;

import com.show.dao.RewardMapper;
import com.show.model.Reward;
import com.show.service.RewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/8/3.
 */
@Service
public class RewardServiceImpl implements RewardService{
    @Resource
    private RewardMapper rewardMapper;

    public void addReward(Reward reward) {
        rewardMapper.addReward(reward);
    }

    public List<Reward> getReward() {
        return rewardMapper.getReward();
    }

    public List<Reward> getRewardByPage(int begin, int end) {
        return rewardMapper.getRewardByPage(begin,end);
    }

    public void deleteReward(Reward reward) {
        rewardMapper.deleteReward(reward);
    }

    public Reward getRewardById(Reward reward) {
        return rewardMapper.getRewardById(reward);
    }

    public void updateReward(Reward reward) {
        rewardMapper.updateReward(reward);
    }
}
