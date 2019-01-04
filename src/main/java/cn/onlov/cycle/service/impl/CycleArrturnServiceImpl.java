package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import cn.onlov.cycle.core.dao.entities.CyclePermission;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnService;
import cn.onlov.cycle.pojo.bo.CycleArrturnBo;
import cn.onlov.cycle.service.CycleArrturnService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CycleArrturnServiceImpl  implements CycleArrturnService {
	@Resource
	private ICycleArrturnService iCycleArrturnService;

	@Override
	public IPage<CycleArrturn> selectByPage(CycleArrturnBo bo, Date startTime, Date endTime) {

		IPage<CycleArrturn> page = new Page<>();
		page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());


		QueryWrapper<CycleArrturn> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(MyStringUtils.isNotEmpty(bo.getBasename()),CycleArrturn::getBasename,bo.getBasename());
		queryWrapper.lambda().eq(MyStringUtils.isNotEmpty(bo.getRoomName()),CycleArrturn::getBasename,bo.getRoomName());
		queryWrapper.lambda().eq(MyStringUtils.isNotEmpty(bo.getLoginName()),CycleArrturn::getBasename,bo.getLoginName());
		queryWrapper.lambda().eq(MyStringUtils.isNotEmpty(bo.getRealName()),CycleArrturn::getBasename,bo.getRealName());
		queryWrapper.lambda().ge(MyStringUtils.isNotEmpty(bo.getEndTime()),CycleArrturn::getEndTime,startTime);
		queryWrapper.lambda().le(MyStringUtils.isNotEmpty(bo.getEndTime()),CycleArrturn::getStartTime,endTime);


		IPage<CycleArrturn> res = iCycleArrturnService.page(page, queryWrapper);
		return res;
	}

}
