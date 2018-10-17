package cn.onlov.cycle.controller;


import cn.onlov.cycle.bo.BusinessUserBo;
import cn.onlov.cycle.dao.entities.BusinessUser;
import cn.onlov.cycle.dao.interfaces.IBusinessUserService;
import cn.onlov.cycle.service.BusinessUserService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import cn.onlov.cycle.vo.BusieessUserVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private BusinessUserService  businessUserService;

    @Resource
    private IBusinessUserService iBusinessUserService;


    /**
     * 查询列表分页查询
     * @param businessUserBo
     * @return
     */
    @RequestMapping("/userList")
    public RspPage test(BusinessUserBo businessUserBo){
        IPage<BusinessUser> businessUserIPage = businessUserService.getBusinessPageUser(businessUserBo);
        BusieessUserVo vo = new BusieessUserVo();
        vo.setData(businessUserIPage);
        RspUtil.setResult(vo,true);
        return vo;
    }

    /**
     * 更新或者添加
     * @param businessUserBo
     * @return
     */
    @RequestMapping("/userUpdate")
    public RspPage userAdd(BusinessUserBo businessUserBo){
        BusieessUserVo vo = new BusieessUserVo();
        BusinessUser businessUser =new BusinessUser() ;
        BeanUtils.copyProperties(businessUserBo,businessUser);
        boolean tag = iBusinessUserService.saveOrUpdate(businessUser);
        RspUtil.setResult(vo,tag);
        return vo;
    }

    /**
     * 删除功能
     * @param businessUserBo
     * @return
     */
    @RequestMapping("/userDel")
    public RspPage userDel(BusinessUserBo businessUserBo){
        BusieessUserVo vo = new BusieessUserVo();
        long id = businessUserBo.getUserId();
        boolean tag = iBusinessUserService.removeById(id);
        RspUtil.setResult(vo,tag);
        return vo;
    }


}
