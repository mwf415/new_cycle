package cn.onlov.cycle.controller;


import cn.onlov.cycle.bo.CycleRoomBo;
import cn.onlov.cycle.dao.entities.CycleRoom;
import cn.onlov.cycle.dao.interfaces.ICycleRoomService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.vo.BusieessUserVo;
import cn.onlov.cycle.vo.CycleRoomVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoomController {

    @Resource
    private ICycleRoomService iCycleRoomService;

    /**
     * 查询列表分页查询
     * @param
     * @return
     */
    @RequestMapping("/roomList")
    public RspPage list( CycleRoomBo cycleRoomBo){
        IPage<CycleRoom> page = new Page<>();
        List<CycleRoom> list = iCycleRoomService.list(new QueryWrapper<CycleRoom>());
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
    @RequestMapping("/roomUpdate")
    public RspPage saveOrUpdate( CycleRoomBo cycleRoomBo){
        CycleRoomVo vo = new CycleRoomVo();
        CycleRoom cycleRoom =new CycleRoom() ;
        BeanUtils.copyProperties(cycleRoomBo,cycleRoom);
        boolean tag = iCycleRoomService.saveOrUpdate(cycleRoom);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param
     * @return
     */
    @RequestMapping("/roomDel")
    public RspPage del(CycleRoomBo cycleRoomBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = cycleRoomBo.getId();
        boolean tag = iCycleRoomService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }




}
