package com.show.controller;

import com.show.model.Department;
import com.show.model.Position;
import com.show.model.Staff;
import com.show.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
@Controller
public class PositionController {
    @Resource
    private PositionService positionService;
    @RequestMapping("/staffInP")
    public String staffInP(Position position, Model model){
        Position position1=positionService.getPositionByIdS(position);
        if (position1==null){
            return "noStaffInP";
        }
        List<Staff> staff=position1.getStaff();
        model.addAttribute("s",staff);
        return "staffInP";
    }
    @RequestMapping("/toAddPosition")
    public String toAddPosition(Department department,Model model){
        Position position=new Position();
        position.setDepartment(department);
        model.addAttribute("p",position);
        return "addPosition";
    }
    @RequestMapping("/addPosition")
    public String addPosition(Position position, int did, Model model){
        Department department=new Department();
        department.setId(did);
        Position position1=positionService.getPositionByName(position);
        if (position1!=null){
            model.addAttribute("failAddP","职位已存在");
            return toAddPosition(department,model);
        }
        position.setDepartment(department);
        positionService.addPosition(position);
        return "redirect:/doDepartment";
    }
    @RequestMapping("/doPosition")
    public String doPosition(Model model){
        List<Position> positions=positionService.positionListWD();
        model.addAttribute("positions",positions);
        return "doPosition";
    }
    @RequestMapping("/doPositionFail")
    public String doPositionFail(Model model){
        List<Position> positions=positionService.positionListWD();
        model.addAttribute("positions",positions);
        model.addAttribute("fail","该职位下有职员或招聘信息，无法删除");
        return "doPosition";
    }
    @RequestMapping("/toUpdatePosition")
    public String toUpdatePosition(Position position, Model model){
        Position position1=positionService.getPositionById(position);
        model.addAttribute("p",position1);
        return "updatePosition";
    }
    @RequestMapping("/updatePosition")
    public String updatePosition(Position position, Model model){
        positionService.updatePosition(position);
        return doPosition(model);
    }
    @RequestMapping("/deletePosition")
    public String deletePosition(Position position,Model model){
        Position position1=positionService.getPositionByIdS(position);
        Position position2=positionService.getPositionByIdR(position);
        if (position1!=null){
            return doPositionFail(model);
        }
        if (position2!=null){
            return doPositionFail(model);
        }
        positionService.deletePositionById(position);
        return doPosition(model);
    }
}
