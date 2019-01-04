package cn.onlov.cycle.controller;


import cn.onlov.cycle.pojo.bo.CycleArrturnBo;
import cn.onlov.cycle.dao.entities.CycleArrturn;
import cn.onlov.cycle.dao.interfaces.ICycleArrturnService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.pojo.vo.BusieessUserVo;
import cn.onlov.cycle.pojo.vo.CycleArrturnVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArrturnController {

    @Resource
    private ICycleArrturnService iCycleArrturnService;

    /**
     * 查询列表分页查询
     * @param
     * @return
     */
    @RequestMapping("/arrturnList")
    public RspPage list( CycleArrturnBo cycleArrturnBo){
        IPage<CycleArrturn> page = new Page<>();
        List<CycleArrturn> list = iCycleArrturnService.list(new QueryWrapper<CycleArrturn>());
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
    @RequestMapping("/arrturnUpdate")
    public RspPage saveOrUpdate( CycleArrturnBo cycleArrturnBo){
        CycleArrturnVo vo = new CycleArrturnVo();
        CycleArrturn cycleArrturn =new CycleArrturn() ;
        BeanUtils.copyProperties(cycleArrturnBo,cycleArrturn);
        boolean tag = iCycleArrturnService.saveOrUpdate(cycleArrturn);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param
     * @return
     */
    @RequestMapping("/cycleArrturnDel")
    public RspPage del(CycleArrturnBo cycleArrturnBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = cycleArrturnBo.getArrturnId();
        boolean tag = iCycleArrturnService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }




}
