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

    public Position getPositionByIdS(Position position) {
        return positionMapper.getPositionByIdS(position);
    }

    public void deletePositionById(Position position) {
        positionMapper.deletePositionById(position);
    }

    public Position getPositionByIdR(Position position) {
        return positionMapper.getPositionByIdR(position);
    }

    public void addPosition(Position position) {
        positionMapper.addPosition(position);
    }

    public Position getPositionByName(Position position) {
        return positionMapper.getPositionByName(position);
    }

    public List<Position> positionListWD() {
        return positionMapper.positionListWD();
    }

    public Position getPositionById(Position position) {
        return positionMapper.getPositionById(position);
    }

    public void updatePosition(Position position) {
        positionMapper.updatePosition(position);
    }

}
