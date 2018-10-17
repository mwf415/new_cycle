package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.bo.BusinessUserBo;
import cn.onlov.cycle.dao.entities.BusinessUser;
import cn.onlov.cycle.dao.interfaces.IBusinessUserService;
import cn.onlov.cycle.service.BusinessUserService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BusinessUserServiceImpl implements BusinessUserService {
    @Resource
    private IBusinessUserService iBusinessUserService;
    @Override
    public IPage<BusinessUser> getBusinessPageUser(BusinessUserBo bo) {
        IPage<BusinessUser> page = new Page<>();
        page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());
        boolean a = MyStringUtils.isNotEmpty(bo.getBaseId());

        IPage<BusinessUser> res = iBusinessUserService.page(page, new QueryWrapper<BusinessUser>().lambda()
                .like(MyStringUtils.isNotEmpty(bo.getRealName()), BusinessUser :: getRealName , bo.getRealName())
                .eq(MyStringUtils.isNotEmpty(bo.getBaseId()),BusinessUser :: getBaseId, bo.getBaseId())
                .eq(MyStringUtils.isNotEmpty(bo.getRoomId()),BusinessUser::getRoomId,bo.getRoomId())
                .eq(MyStringUtils.isNotEmpty(bo.getGrade()),BusinessUser::getGrade, bo.getGrade())
                .orderByDesc(BusinessUser::getUserId));


        return res;
    }
}
