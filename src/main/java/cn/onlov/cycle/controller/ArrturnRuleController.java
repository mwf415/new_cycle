package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.core.dao.entities.CycleBase;
import cn.onlov.cycle.core.dao.entities.CycleRoom;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.pojo.bo.CycleArrturnRuleBo;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import cn.onlov.cycle.service.CycleArrturnRuleService;
import cn.onlov.cycle.service.CycleBaseService;
import cn.onlov.cycle.service.CycleRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/arrturnRules")
public class ArrturnRuleController {

    @Resource
    private CycleArrturnRuleService cycleArrturnRuleService;
    @Resource
    private ICycleArrturnRuleService iCycleArrturnRuleService;
    @Resource
    private CycleBaseService cycleBaseService;


    @RequestMapping
    public Map<String,Object> getAll( String draw){
        Map<String,Object> map = new HashMap<>();
        List<CycleBase> cycleBases = cycleBaseService.selectAll();
        map.put("draw",draw);
        map.put("recordsTotal",cycleBases.size());
        map.put("recordsFiltered",cycleBases.size());
        map.put("data", cycleBases);
        return map;
    }

@Autowired
private CycleRoomService cycleRoomService;

    @RequestMapping(value = "/getByBaseName")
    public Map<String,Object> getByBaseName(String baseName){
        List<CycleArrturnRule> cycleArrturnRules = cycleBaseService.listByCycleBaseName(baseName);
        Map<String,Object> map = new HashMap<>();
//        map.put("draw",nul);
        map.put("recordsTotal",cycleArrturnRules.size());
        map.put("recordsFiltered",cycleArrturnRules.size());
        map.put("data", cycleArrturnRules);

        return map;
    }

    @RequestMapping(value = "/update")
    public String update(CycleArrturnRule cycleArrturnRule){
        try{
            iCycleArrturnRuleService.saveOrUpdate(cycleArrturnRule);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping(value = "/add")
    public String add(CycleArrturnRule cycleArrturnRule){
        try{
            iCycleArrturnRuleService.saveOrUpdate(cycleArrturnRule);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer [] ids){
        try{
            if(ids.length>0){
                List<Integer> idsList = new ArrayList<>();
                for (Integer id : ids) {
                    idsList.add(id);
                }
                iCycleArrturnRuleService.removeByIds(idsList);
                return "success";
            }
            return "fail";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

}
