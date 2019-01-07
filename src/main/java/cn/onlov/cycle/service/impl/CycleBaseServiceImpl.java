package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.constants.Constants;
import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.core.dao.entities.CycleBase;
import cn.onlov.cycle.core.dao.entities.CyclePermission;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.core.dao.interfaces.ICycleBaseService;
import cn.onlov.cycle.pojo.bo.CycleBaseBo;
import cn.onlov.cycle.service.CycleBaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class CycleBaseServiceImpl  implements CycleBaseService {
    @Resource
    private ICycleBaseService iCycleBaseService;

    @Autowired
    private ICycleArrturnRuleService iCycleArrturnRuleService;



    @Override
    public IPage<CycleBase> selectByPage(CycleBaseBo bo) {
        IPage<CycleBase> page = new Page<>();
        page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());

        IPage<CycleBase> res = iCycleBaseService.page(page, new QueryWrapper<CycleBase>().lambda().orderByDesc(CycleBase::getId));
        return res;
    }

    @Override
    public List<CycleBase> selectAll() {
        List<CycleBase> res = iCycleBaseService.list( new QueryWrapper<CycleBase>().lambda().orderByDesc(CycleBase::getId));
        return res;
    }

    @Override
    public void deleteByKey(Integer key) {
        iCycleBaseService.remove( new QueryWrapper<CycleBase>().lambda().eq(CycleBase::getId,key));
    }

    @Override
    public List<CycleArrturnRule> listArrturnRuleByCycleBaseName(String baseName) {
        List<CycleArrturnRule> list = iCycleArrturnRuleService.list(new QueryWrapper<CycleArrturnRule>().lambda().eq(CycleArrturnRule::getBaseName, baseName));

        return list;
    }
}
