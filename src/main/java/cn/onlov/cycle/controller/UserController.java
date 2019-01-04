package cn.onlov.cycle.controller;


import cn.onlov.cycle.pojo.bo.UserBo;
import cn.onlov.cycle.dao.entities.BusinessUser;
import cn.onlov.cycle.dao.interfaces.IBusinessUserService;
import cn.onlov.cycle.service.CycleUserService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.pojo.vo.BusieessUserVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private CycleUserService cycleUserService;

    @Resource
    private IBusinessUserService iBusinessUserService;


    /**
     * 查询列表分页查询
     * @param userBo
     * @return
     */
    @RequestMapping("/userList")
    public RspPage test(UserBo userBo){
        IPage<BusinessUser> businessUserIPage = cycleUserService.getBusinessPageUser(userBo);
        BusieessUserVo vo = new BusieessUserVo();
        vo.setData(businessUserIPage);
        RspUtil.setResult(vo,true);
        return vo;
    }

    /**
     * 更新或者添加
     * @param userBo
     * @return
     */
    @RequestMapping("/userUpdate")
    public RspPage userAdd(UserBo userBo){
        BusieessUserVo vo = new BusieessUserVo();
        BusinessUser businessUser =new BusinessUser() ;
        BeanUtils.copyProperties(userBo,businessUser);
        boolean tag = iBusinessUserService.saveOrUpdate(businessUser);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param userBo
     * @return
     */
    @RequestMapping("/userDel")
    public RspPage userDel(UserBo userBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = userBo.getUserId();
        boolean tag = iBusinessUserService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }


}
