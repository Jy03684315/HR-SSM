package com.show.service.Impl;

import com.show.dao.PositionMapper;
import com.show.model.Position;
import com.show.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Resource
    private PositionMapper positionMapper;

    public List<Position> positionList() {
        return positionMapper.positionList();
    }
}
