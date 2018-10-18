package cn.onlov.cycle.service;

import cn.onlov.cycle.bo.CycleArrturnRuleBo;
import cn.onlov.cycle.dao.entities.CycleArrturnRule;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaifa
 * @since 2018-09-28
 */
public interface CycleArrturnRuleService  {
    public IPage<CycleArrturnRule> getCyclePage(CycleArrturnRuleBo bo) ;
}
