package com.show.dao;

import com.show.model.Staff;
import com.show.model.StoT;
import com.show.model.Train;
import org.springframework.stereotype.Repository;

/**
 * Created by Show on 2018/8/2.
 */
@Repository
public interface StoTMapper {
    void addStoT(StoT stoT);
}
