package cn.onlov.cycle.service;


import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.pojo.bo.CycleArrturnRuleBo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface CycleArrturnRuleService  {
    IPage<CycleArrturnRule> selectByPage(CycleArrturnRuleBo bo) ;
    List<CycleArrturnRule> getByBaseName(String baseName) ;
}
