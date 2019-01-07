package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnService;
import cn.onlov.cycle.pojo.bo.CycleArrturnBo;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import cn.onlov.cycle.service.CycleArrturnService;
import cn.onlov.cycle.service.CycleRolePermissionService;
import cn.onlov.cycle.shiro.ShiroService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/arrturns")
public class ArrturnController {

    @Resource
    private CycleArrturnService cycleArrturnService;
    @Resource
    private ICycleArrturnService iCycleArrturnService;
    @Resource
    private ShiroService shiroService;

    @RequestMapping
    public Map<String,Object> getAll(CycleArrturn cycleArrturn, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        CycleArrturnBo bo  = new CycleArrturnBo();
        BeanUtils.copyProperties(cycleArrturn,bo);
        bo.setCurr(start);
        bo.setPageSize(length);

        IPage<CycleArrturn> pageInfo = cycleArrturnService.selectByPage(bo);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getRecords());
        return map;
    }


    @RequestMapping(value = "/update")
    public String update(CycleArrturn permission){
        try{
            iCycleArrturnService.saveOrUpdate(permission);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }


}
