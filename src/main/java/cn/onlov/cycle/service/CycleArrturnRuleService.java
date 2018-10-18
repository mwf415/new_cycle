package cn.onlov.cycle.service;

import cn.onlov.cycle.bo.CycleArrturnRuleBo;
import cn.onlov.cycle.dao.entities.CycleArrturnRule;
import com.baomidou.mybatisplus.core.metadata.IPage;


public interface CycleArrturnRuleService  {
    IPage<CycleArrturnRule> getCyclePage(CycleArrturnRuleBo bo) ;
}
