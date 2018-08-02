package com.show.service.Impl;

import com.show.dao.StoTMapper;
import com.show.model.StoT;
import com.show.service.StoTService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/8/2.
 */
@Service
public class StoTServiceImpl implements StoTService{
    @Resource
    private StoTMapper stoTMapper;

    public void addStoT(StoT stoT) {
        stoTMapper.addStoT(stoT);
    }
}
