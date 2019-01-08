package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnService;
import cn.onlov.cycle.core.dao.interfaces.IUserService;
import cn.onlov.cycle.pojo.bo.CycleArrturnBo;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import cn.onlov.cycle.service.CycleArrturnRuleService;
import cn.onlov.cycle.service.CycleArrturnService;
import cn.onlov.cycle.service.CycleRolePermissionService;
import cn.onlov.cycle.service.CycleUserService;
import cn.onlov.cycle.shiro.ShiroService;
import cn.onlov.cycle.util.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/arrturns")
public class ArrturnController {

    @Resource
    private CycleArrturnService cycleArrturnService;
    @Resource
    private ICycleArrturnService iCycleArrturnService;
    @Autowired
    private CycleArrturnRuleService cycleArrturnRuleService;
    @Autowired
    private CycleUserService cycleUserService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping
    public Map<String, Object> getAll(String loginName, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(loginName)) {
            map.put("draw", draw);
            map.put("recordsTotal", 0);
            map.put("recordsFiltered", 0);
            map.put("data", null);
            return map;
        } else {
            List<CycleArrturn> pageInfo = cycleArrturnService.getByLoginName(loginName);
            for (CycleArrturn cycleArrturn : pageInfo) {
                StringBuilder sb = new StringBuilder();
                sb.append(cycleArrturn.getTeacherName1()).append(":").append(cycleArrturn.getTeacherName2());
                cycleArrturn.setTeacherName1(sb.toString());
            }
            map.put("draw", draw);
            map.put("recordsTotal", pageInfo.size());
            map.put("recordsFiltered", pageInfo.size());
            map.put("data", pageInfo);
            return map;
        }
    }


    @RequestMapping(value = "/update")
    public String update(CycleArrturn cycleArrturn) {
        try {
            iCycleArrturnService.saveOrUpdate(cycleArrturn);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String[] loginNames, String baseName, String startTime) {
        List<CycleArrturnRule> arrTurnRules = cycleArrturnRuleService.getByBaseName(baseName);
        for (CycleArrturnRule arrturnRule : arrTurnRules) {
            System.out.print(arrturnRule.getRoomName() + ":" + arrturnRule.getRoomSort());
        }
        Collections.shuffle(arrTurnRules);
        for (CycleArrturnRule arrturnRule : arrTurnRules) {
            System.out.print(arrturnRule.getRoomName() + ":" + arrturnRule.getRoomSort());
        }
        System.out.println();
        if (loginNames != null && loginNames.length > 0) {
            for (String loginName : loginNames) {
                /**
                 * 随机排序，一个人一个顺序
                 */
                Collections.shuffle(arrTurnRules);
                User user = cycleUserService.selectByLoginName(loginName);
                if ("" != startTime && null != startTime) {
                    startTime = startTime + " 00:00:00";
                    Timestamp startTimeTemp = DateUtil.str2Timestamp(startTime, null);
                    startTimeTemp.setHours(01);
                    Timestamp endTime;
                    for (CycleArrturnRule arrTurnRule : arrTurnRules) {
                        CycleArrturn arrTurn = new CycleArrturn();
                        arrTurn.setBasename(arrTurnRule.getBaseName());
                        arrTurn.setRoomName(arrTurnRule.getRoomName());
                        arrTurn.setStartTime(startTimeTemp);
                        String period = arrTurnRule.getPeriod();
                        Double num1 = Double.valueOf(period.toString());
                        endTime = DateUtil.addMonth(startTimeTemp, num1);
                        arrTurn.setCheckStatus("1");  // 1 是审核通过， 0 是未审核
                        arrTurn.setTrainTime("3"); //通用3年，不做其他设置
                        arrTurn.setHospitalId(user.getHospitalId());
                        arrTurn.setRealName(user.getRealName());
                        arrTurn.setLoginName(user.getLoginName());
                        arrTurn.setHospitalId(user.getHospitalId());
                        arrTurn.setEndTime(endTime);
                        arrTurn.setBatch("0"); // 批量安排
                        arrTurn.setGrade(user.getGrade() + "");
                        iCycleArrturnService.save(arrTurn);
                        //为下一个循环做准备
                        startTimeTemp = DateUtil.addday(endTime, 1);
                    }
                    user.setIsAt(1);
                    iUserService.saveOrUpdate(user);
                }
                return "success";
            }
        }
        return "fail";
    }
}
