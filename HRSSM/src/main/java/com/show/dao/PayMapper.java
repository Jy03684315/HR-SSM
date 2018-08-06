package com.show.dao;

import com.show.model.Pay;
import com.show.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/8/7.
 */
@Repository
public interface PayMapper {
    void addPay(Pay pay);
    void changeState(Pay pay);
    List<Pay> getPayByStaff(Staff staff);
    List<Pay> getPayByStaffPage(int sid,int begin,int end);
    List<Pay> getPayByState(int state);
    List<Pay> getPayByStatePage(int state,int begin,int end);
    Pay getPayById(Pay pay);
    void changeStateOnly(Pay pay);
}
