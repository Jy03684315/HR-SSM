package com.show.controller;

import com.show.service.PositionService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Show on 2018/7/26.
 */
@Controller
public class PositionController {
    @Resource
    private PositionService positionService;
}
