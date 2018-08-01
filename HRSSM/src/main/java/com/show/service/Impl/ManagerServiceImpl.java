package com.show.service.Impl;

import com.show.dao.ManagerMapper;
import com.show.model.Manager;
import com.show.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/7/30.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Resource
    private ManagerMapper managerMapper;

    public Manager getManager(Manager manager) {
        return managerMapper.getManager(manager);
    }
}
