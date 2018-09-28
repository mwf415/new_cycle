package cn.onlov.cycle.controller;


import cn.onlov.cycle.Vo.BusieessUserVo;
import cn.onlov.cycle.dao.entities.BusinessUser;
import cn.onlov.cycle.dao.interfaces.IBusinessUserService;
import cn.onlov.cycle.util.RspPage;
import cn.onlov.cycle.util.RspUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    private IBusinessUserService iBusinessUserService;

    @RequestMapping("/test")
    public String test(){
        RspPage rspPage = new RspPage();
        List<BusinessUser> list = new ArrayList<BusinessUser>();

        BusinessUser user = iBusinessUserService.getById(1);
        list.add(user);
        BusieessUserVo vo = new BusieessUserVo();
        RspUtil.successMessage(list,"查询成功");
        return vo.toString();
    }
}
