package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import cn.onlov.cycle.core.dao.entities.CycleBase;
import cn.onlov.cycle.pojo.bo.CycleBaseBo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface CycleBaseService{
	IPage<CycleBase> selectByPage(CycleBaseBo base);
	List<CycleBase> selectAll();
	void deleteByKey(Integer key);
	//根据基地获取轮转科室
	List<CycleArrturnRule> listArrturnRuleByCycleBaseName(String baseName);
}
