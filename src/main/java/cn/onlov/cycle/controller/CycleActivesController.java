package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleActives;
import cn.onlov.cycle.core.dao.entities.CycleActivesQuest;
import cn.onlov.cycle.core.dao.entities.CycleActivesQuestUser;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesService;
import cn.onlov.cycle.core.dao.interfaces.IUserService;
import cn.onlov.cycle.pojo.bo.CycleActivesBo;
import cn.onlov.cycle.pojo.bo.UserBo;
import cn.onlov.cycle.service.CycleActivesService;
import cn.onlov.cycle.util.PasswordHelper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/22.
 */
@RestController
@RequestMapping("/cycleActivess")
public class CycleActivesController {
    @Resource
    private ICycleActivesService iCycleActivesService;
    @Resource
    private IUserService iUserService;

    @Resource
    private CycleActivesService cycleActivesService;

    @RequestMapping
    public Map<String, Object> getAll(CycleActives cycleActives, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        CycleActivesBo bo = new CycleActivesBo();
        BeanUtils.copyProperties(cycleActives, bo);
        start = start / length;
        bo.setCurr(start);
        bo.setPageSize(length);

        IPage<CycleActives> pageInfo = cycleActivesService.selectByPage(bo);
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getRecords());
        return map;
    }


    @RequestMapping(value = "/add")
    public String add(CycleActives cycleActives, String[] teachersLogins, String[] studentsLogins) {
        try {
            cycleActivesService.saveOrUpdate(cycleActives, teachersLogins, studentsLogins);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            cycleActivesService.deleteByKey(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/addQuest")
    public String addQuest(CycleActivesQuest cycleActivesQuest) {
        try {
            cycleActivesService.saveOrUpdateActivesQuest(cycleActivesQuest);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/addQuestUser")
    public String addQuestUser(CycleActivesQuestUser cycleActivesQuestUser) {
        try {
            cycleActivesService.saveOrUpdateAcitvesQuestUser(cycleActivesQuestUser);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
