package com.show.dao;

import com.show.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Repository
public interface PositionMapper {
    List<Position> positionList();
}