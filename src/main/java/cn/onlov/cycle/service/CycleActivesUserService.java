package cn.onlov.cycle.service;


import cn.onlov.cycle.core.dao.entities.CycleActivesUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CycleActivesUserService  {

    /**
     *
     * @param activesId
     * @param 用户类型，1 老师，2 学生
     * @return
     */
    List<CycleActivesUser> getByAcitvesIdAndType (Integer activesId,Integer type );

}
