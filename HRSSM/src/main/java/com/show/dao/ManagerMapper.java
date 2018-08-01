package com.show.dao;

import com.show.model.Manager;
import org.springframework.stereotype.Repository;

/**
 * Created by Show on 2018/7/30.
 */
@Repository
public interface ManagerMapper {
    Manager getManager(Manager manager);
}
