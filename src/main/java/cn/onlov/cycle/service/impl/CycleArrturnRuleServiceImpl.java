package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.pojo.bo.CycleArrturnRuleBo;
import cn.onlov.cycle.service.CycleArrturnRuleService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleArrturnRuleServiceImpl implements CycleArrturnRuleService {
    @Autowired
    private ICycleArrturnRuleService iCycleArrturnRuleService;

    @Override
    public IPage<CycleArrturnRule> selectByPage(CycleArrturnRuleBo bo) {
        IPage<CycleArrturnRule> page = new Page<>();
        page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());

        IPage<CycleArrturnRule> res = iCycleArrturnRuleService.page(page, new QueryWrapper<CycleArrturnRule>().lambda()
                .like(MyStringUtils.isNotEmpty(bo.getBaseName()), CycleArrturnRule :: getBaseName , bo.getBaseName())
                .eq(MyStringUtils.isNotEmpty(bo.getType()),CycleArrturnRule ::getType, bo.getType())
                .orderByDesc(CycleArrturnRule::getRoomSort));
        return res;
    }

    @Override
    public List<CycleArrturnRule> getByBaseName(String baseName) {
        List<CycleArrturnRule> res = iCycleArrturnRuleService.list(new QueryWrapper<CycleArrturnRule>().lambda()
                .eq(MyStringUtils.isNotEmpty(baseName), CycleArrturnRule :: getBaseName , baseName)
                .orderByDesc(CycleArrturnRule::getRoomSort));
        return res;
    }
}
