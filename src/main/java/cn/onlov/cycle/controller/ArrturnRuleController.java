package cn.onlov.cycle.controller;


import cn.onlov.cycle.bo.CycleArrturnRuleBo;
import cn.onlov.cycle.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.service.CycleArrturnRuleService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.vo.BusieessUserVo;
import cn.onlov.cycle.vo.CycleArrturnRuleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ArrturnRuleController {

    @Resource
    private CycleArrturnRuleService cycleArrturnRuleService;
    @Resource
    private ICycleArrturnRuleService iCycleArrturnRuleService;

    /**
     * 查询列表分页查询
     * @param
     * @return
     */
    @RequestMapping("/arrturnRuleList")
    public RspPage list( CycleArrturnRuleBo cycleArrturnRuleBo){
        BusieessUserVo vo = new BusieessUserVo();
        IPage<CycleArrturnRule> cyclePage = cycleArrturnRuleService.getCyclePage(cycleArrturnRuleBo);

        vo.setData(cyclePage);
        RspUtil.setResult(vo,true);
        return vo;
    }

    /**
     * 更新或者添加
     * @param
     * @return
     */
    @RequestMapping("/arrturnRuleUpdate")
    public RspPage saveOrUpdate( CycleArrturnRuleBo cycleArrturnRuleBo){
        CycleArrturnRuleVo vo = new CycleArrturnRuleVo();
        CycleArrturnRule cycleArrturnRule =new CycleArrturnRule() ;
        BeanUtils.copyProperties(cycleArrturnRuleBo,cycleArrturnRule);
        boolean tag = iCycleArrturnRuleService.saveOrUpdate(cycleArrturnRule);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param
     * @return
     */
    @RequestMapping("/cycleArrturnRuleDel")
    public RspPage del(CycleArrturnRuleBo cycleArrturnRuleBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = cycleArrturnRuleBo.getArrturnRuleId();
        boolean tag = iCycleArrturnRuleService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }




}
