package com.show.service;

import com.show.model.Position;

import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
public interface PositionService {
    List<Position> positionList();
    Position getPositionByIdS(Position position);
    void deletePositionById(Position position);
    Position getPositionByIdR(Position position);
    void addPosition(Position position);
    Position getPositionByName(Position position);
    List<Position> positionListWD();
    Position getPositionById(Position position);
    void updatePosition(Position position);
}
