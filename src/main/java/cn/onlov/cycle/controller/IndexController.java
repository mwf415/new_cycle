package cn.onlov.cycle.controller;


import cn.onlov.cycle.bo.BusinessUserBo;
import cn.onlov.cycle.service.BusinessUserService;
import cn.onlov.cycle.vo.BusieessUserVo;
import cn.onlov.cycle.dao.entities.BusinessUser;
import cn.onlov.cycle.dao.interfaces.IBusinessUserService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Resource
    private BusinessUserService  businessUserService;

    @RequestMapping("/test")
    public RspPage test(){
        BusinessUserBo  bo = new BusinessUserBo();
        bo.setPageNo(0);
        bo.setPageSize(10);
        IPage<BusinessUser> businessUserIPage = businessUserService.getBusinessPageUser(bo);
        BusieessUserVo vo = new BusieessUserVo();
        vo.setData(businessUserIPage);
        RspUtil.successMessage(vo,"查询成功");

        return vo;
    }
}
