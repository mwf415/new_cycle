package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CycleActives;
import cn.onlov.cycle.core.dao.entities.CycleActivesQuest;
import cn.onlov.cycle.core.dao.entities.CycleActivesQuestUser;
import cn.onlov.cycle.core.dao.entities.CycleActivesUser;
import cn.onlov.cycle.pojo.bo.CycleActivesBo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;


public interface CycleActivesService  {
    IPage<CycleActives> selectByPage(CycleActivesBo bo);  // 分页查询功能

    /**
     * 保存或者更新的服务
     * @param cycleActives
     * @param teachersLogins
     * @param studentsLogins
     */
    void saveOrUpdate(CycleActives cycleActives, String [] teachersLogins , String [] studentsLogins); // 添加活动，包括添加老师和学生

    void deleteByKey(Integer key);

    void saveOrUpdateActivesQuest(CycleActivesQuest cycleActivesQuest);// 添加活动提的问题

    void saveOrUpdateAcitvesQuestUser(CycleActivesQuestUser cycleActivesQuestUser);// 添加学生回答的问题

    /**
     * 活动完成的更新
     * @param cycleActives
     */
    void saveOrUpdate(CycleActives cycleActives);

    /**
     * 根据活动Id查找用户，传入的老师和学生Id
     * @param activesId
     * @return
     */
    Map< String,Object > getActivesUserByActivesId (Integer activesId );
    List<CycleActivesQuestUser> getActivesQuestUserByActivesId (Integer activesId);
    List<CycleActivesQuest> getActivesQuestByActivesId (Integer activesId);


}
