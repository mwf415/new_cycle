package cn.onlov.cycle.controller;


import cn.onlov.cycle.bo.CycleBaseBo;
import cn.onlov.cycle.dao.entities.CycleBase;
import cn.onlov.cycle.dao.interfaces.ICycleBaseService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.vo.BusieessUserVo;
import cn.onlov.cycle.vo.CycleBaseVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BaseController {

    @Resource
    private ICycleBaseService iCycleBaseService;

    /**
     * 查询列表分页查询
     * @param
     * @return
     */
    @RequestMapping("/baseList")
    public RspPage test( CycleBaseBo cycleBaseBo){
        IPage<CycleBase> page = new Page<>();
        List<CycleBase> list = iCycleBaseService.list(new QueryWrapper<CycleBase>());
        BusieessUserVo vo = new BusieessUserVo();
        vo.setData(list);
        RspUtil.setResult(vo,true);
        return vo;
    }

    /**
     * 更新或者添加
     * @param
     * @return
     */
    @RequestMapping("/baseUpdate")
    public RspPage saveOrUpdate( CycleBaseBo cycleBaseBo){
        CycleBaseVo vo = new CycleBaseVo();
        CycleBase cycleBase =new CycleBase() ;
        BeanUtils.copyProperties(cycleBaseBo,cycleBase);
        boolean tag = iCycleBaseService.saveOrUpdate(cycleBase);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param
     * @return
     */
    @RequestMapping("/userDel")
    public RspPage del(CycleBaseBo cycleBaseBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = cycleBaseBo.getBaseId();
        boolean tag = iCycleBaseService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }




}
