package cn.onlov.cycle.service.impl;


import cn.onlov.cycle.core.dao.entities.CycleActivesUser;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesUserService;
import cn.onlov.cycle.service.CycleActivesUserService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleActivesUserServiceImpl implements CycleActivesUserService {



    @Autowired
    private ICycleActivesUserService iCycleActivesUserService;
    @Override
    public List<CycleActivesUser> getByAcitvesIdAndType(Integer activesId, Integer identityId){
        QueryWrapper<CycleActivesUser> queryWrapper  = new QueryWrapper<>();
        queryWrapper.lambda().eq(!MyStringUtils.isNotEmpty(activesId), CycleActivesUser::getActivesId,activesId)
                .eq(!MyStringUtils.isNotEmpty(identityId),CycleActivesUser::getIdentityId,identityId);

        List<CycleActivesUser> list = iCycleActivesUserService.list(queryWrapper);
        return list;

    }

}
