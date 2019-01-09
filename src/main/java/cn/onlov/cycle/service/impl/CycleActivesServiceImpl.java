package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.core.dao.entities.*;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesQuestService;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesQuestUserService;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesService;
import cn.onlov.cycle.core.dao.interfaces.ICycleActivesUserService;
import cn.onlov.cycle.pojo.bo.CycleActivesBo;
import cn.onlov.cycle.service.CycleActivesQuestUserService;
import cn.onlov.cycle.service.CycleActivesService;
import cn.onlov.cycle.service.CycleUserService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CycleActivesServiceImpl implements CycleActivesService {
    @Autowired
    private ICycleActivesService iCycleActivesService;

    @Autowired
    private ICycleActivesUserService iCycleActivesUserService;

    @Autowired
    private CycleUserService cycleUserService;

    @Autowired
    private ICycleActivesQuestService iCycleActivesQuestService;


    @Autowired
    private ICycleActivesQuestUserService iCycleActivesQuestUserService;
    @Override
    public IPage<CycleActives> selectByPage(CycleActivesBo bo) {
        IPage<CycleActives> page = new Page<>();
        page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());

        IPage<CycleActives> res = iCycleActivesService.page(page, new QueryWrapper<CycleActives>().lambda()
                .like(MyStringUtils.isNotEmpty(bo.getBaseName()), CycleActives::getBaseName, bo.getBaseName())
                .eq(MyStringUtils.isNotEmpty(bo.getRoomName()), CycleActives::getRoomName, bo.getRoomName())
                .ge(MyStringUtils.isNotEmpty(bo.getEndTime()), CycleActives::getEndTime, bo.getSearchStartTime())
                .like(MyStringUtils.isNotEmpty(bo.getTitle()), CycleActives::getTitle, bo.getTitle())
                .ge(MyStringUtils.isNotEmpty(bo.getEndTime()), CycleActives::getEndTime, bo.getSearchStartTime())
                .eq(MyStringUtils.isNotEmpty(bo.getStatus()), CycleActives::getStatus, bo.getStatus())
                .eq(MyStringUtils.isNotEmpty(bo.getIsOver()), CycleActives::getIsOver, bo.getIsOver())
                .eq(MyStringUtils.isNotEmpty(bo.getCreater()), CycleActives::getCreater, bo.getCreater())
                .orderByDesc(CycleActives::getId));
        return res;

    }



    @Override
    public void saveOrUpdate(CycleActives cycleActives, String[] teachersLogins, String[] studentsLogins) {
        boolean save = iCycleActivesService.saveOrUpdate(cycleActives);
        if (save) {
            Integer activesId = cycleActives.getId();
            // 先移除以前的关联的老师和学生
            deleteActivesUserByActivesId(activesId);
            //然后插入新的老师和学生
            insertActivesUser(cycleActives, teachersLogins, activesId,1);// 插入活动 1 是老师 2 是学生
            insertActivesUser(cycleActives, studentsLogins, activesId,2);// 1 是老师 2 是学生
        }
    }

    //
    @Override
    public void deleteByKey(Integer activesId) {
        iCycleActivesService.removeById(activesId); // 删除活动
        deleteActivesUserByActivesId(activesId);    // 删除活动关联的用户
        iCycleActivesQuestService.remove(new QueryWrapper<CycleActivesQuest>().lambda().eq(CycleActivesQuest::getActivesId,activesId)); //删除关联的问题
        iCycleActivesQuestUserService.remove(new QueryWrapper<CycleActivesQuestUser>().lambda().
                eq(CycleActivesQuestUser::getActivesId,activesId)); //删除关联的用户和问题关系



    }


    @Override
    public void saveOrUpdateActivesQuest(CycleActivesQuest cycleActivesQuest) {
        iCycleActivesQuestService.saveOrUpdate(cycleActivesQuest);


    }

    @Override
    public void saveOrUpdateAcitvesQuestUser(CycleActivesQuestUser cycleActivesQuestUser) {
        iCycleActivesQuestUserService.saveOrUpdate(cycleActivesQuestUser);
    }

    @Override
    public void saveOrUpdate(CycleActives cycleActives) {
        cycleActives.setIsOver("1");
        iCycleActivesService.saveOrUpdate(cycleActives);
    }

    private void deleteActivesUserByActivesId(Integer key) {
        QueryWrapper<CycleActivesUser> cycleActivesUserQueryWrapper = new QueryWrapper<>();
        cycleActivesUserQueryWrapper.lambda().eq(CycleActivesUser::getActivesId, key);
        iCycleActivesUserService.remove(cycleActivesUserQueryWrapper);
    }

    private void insertActivesUser(CycleActives cycleActives, String[] teachersLogins, Integer activesId, Integer useType) {
        if (teachersLogins.length > 0) {
            for (String teachersLogin : teachersLogins) {
                CycleActivesUser teacher = new CycleActivesUser();
                teacher.setActivesId(activesId);
                teacher.setLoginName(teachersLogin);
                User user = cycleUserService.selectByLoginName(teachersLogin);
                teacher.setStatus(cycleActives.getStatus());
                if (null != user) {
                    teacher.setName(user.getRealName());
                }
                teacher.setIdentityId(useType);//  设置老师
            }
        }
    }




}
