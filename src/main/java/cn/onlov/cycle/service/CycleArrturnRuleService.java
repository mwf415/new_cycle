package cn.onlov.cycle.service;


import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.pojo.bo.CycleArrturnRuleBo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface CycleArrturnRuleService  {
    IPage<CycleArrturnRule> getCyclePage(CycleArrturnRuleBo bo) ;
}
