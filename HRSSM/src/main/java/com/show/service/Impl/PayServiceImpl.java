package com.show.service.Impl;

import com.show.dao.PayMapper;
import com.show.model.Pay;
import com.show.model.Staff;
import com.show.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/8/7.
 */
@Service
public class PayServiceImpl implements PayService{
    @Resource
    private PayMapper payMapper;

    public void addPay(Pay pay) {
        payMapper.addPay(pay);
    }

    public void changeState(Pay pay) {
        payMapper.changeState(pay);
    }

    public List<Pay> getPayByStaff(Staff staff) {
        return payMapper.getPayByStaff(staff);
    }

    public List<Pay> getPayByStaffPage(int sid, int begin, int end) {
        return payMapper.getPayByStaffPage(sid,begin,end);
    }

    public List<Pay> getPayByState(int state) {
        return payMapper.getPayByState(state);
    }

    public List<Pay> getPayByStatePage(int state, int begin, int end) {
        return payMapper.getPayByStatePage(state,begin,end);
    }

    public Pay getPayById(Pay pay) {
        return payMapper.getPayById(pay);
    }

    public void changeStateOnly(Pay pay) {
        payMapper.changeStateOnly(pay);
    }
}
