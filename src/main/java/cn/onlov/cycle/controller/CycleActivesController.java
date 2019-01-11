package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.*;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesService;
import cn.onlov.cycle.core.dao.interfaces.IUserService;
import cn.onlov.cycle.pojo.bo.CycleActivesBo;
import cn.onlov.cycle.pojo.bo.UserBo;
import cn.onlov.cycle.service.CycleActivesService;
import cn.onlov.cycle.service.CycleActivesUserService;
import cn.onlov.cycle.util.Constant;
import cn.onlov.cycle.util.PasswordHelper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yangqj on 2017/4/22.
 */
@RestController
@RequestMapping("/cycleActives")
public class CycleActivesController {
    @Resource
    private ICycleActivesService iCycleActivesService;
    @Resource
    private IUserService iUserService;

    @Resource
    private CycleActivesService cycleActivesService;



    @RequestMapping
    public Map<String, Object> getAll(CycleActives cycleActives, Date startTime, Date endTime , String teacherName, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        CycleActivesBo bo = new CycleActivesBo();

        BeanUtils.copyProperties(cycleActives, bo);
        start = start / length;
        bo.setCurr(start);
        bo.setPageSize(length);

        IPage<CycleActives> pageInfo = cycleActivesService.selectByPage(bo);
        List<CycleActives> records = pageInfo.getRecords();
        List<CycleActivesBo> cycleActivesBos = new ArrayList<>();
        for (CycleActives record : records) {
            CycleActivesBo cycleActivesBo  = new CycleActivesBo();
            Map<String , Object> userMap = cycleActivesService.getActivesUserByActivesId(record.getId());
            StringBuilder teacherBuilder = (StringBuilder) userMap.get(Constant.TEACHERSSTR);//１　 是学生， 2 是老师
            StringBuilder studentBuilder = (StringBuilder) userMap.get(Constant.STUDENTSSTR);
            Integer studentsNum = (Integer) userMap.get(Constant.STUDENTSNUM);
            BeanUtils.copyProperties(record,cycleActivesBo);

            cycleActivesBo.setTeachers(teacherBuilder+"");
            cycleActivesBo.setStudentsNum(studentsNum);
            cycleActivesBos.add(cycleActivesBo);

        }

        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", cycleActivesBos);
        return map;
    }

    @Autowired
    private CycleActivesUserService cycleActivesUserService;

    @RequestMapping("/details")
    public Map<String, Object> details(Integer activesId, String draw,
                                       @RequestParam(required = false, defaultValue = "1") int start,
                                       @RequestParam(required = false, defaultValue = "10") int length) {

        Map<String,Object> map = new HashMap<>();
        List<CycleActivesUser> list = cycleActivesUserService.getByAcitvesIdAndType(activesId, 2);//

        map.put("draw", draw);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        map.put("data", list);
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
