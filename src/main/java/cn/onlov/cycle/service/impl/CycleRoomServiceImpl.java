package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.core.dao.entities.CycleRoom;
import cn.onlov.cycle.core.dao.interfaces.ICycleArrturnRuleService;
import cn.onlov.cycle.core.dao.interfaces.ICycleRoomService;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import cn.onlov.cycle.service.CycleRoomService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CycleRoomServiceImpl  implements CycleRoomService {
	@Autowired
	private ICycleRoomService iCycleRoomService;


	@Resource
	private ICycleArrturnRuleService iCycleArrturnRuleService;
	
	@Override
	public IPage<CycleRoom> selectByPage(CycleRoomBo bo) {

		IPage<CycleRoom> page = new Page<>();
		page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());
		QueryWrapper<CycleRoom> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(MyStringUtils.isNotEmpty(bo.getValue()),CycleRoom::getValue,bo.getValue());



		IPage<CycleRoom> res = iCycleRoomService.page(page, new QueryWrapper<CycleRoom>().lambda().orderByDesc(CycleRoom::getId));
		return res;

}
	
	@Override
	public List<CycleRoom> selectAll() {

		QueryWrapper<CycleRoom> queryWrapper = new QueryWrapper<>();
		List<CycleRoom>list = iCycleRoomService.list(queryWrapper);

		return list;
	}

	@Override
	public void deleteByKey(Integer key) {
		QueryWrapper<CycleRoom> queryWrapper = new QueryWrapper<>();
		boolean list = iCycleRoomService.remove(queryWrapper.lambda().eq(CycleRoom::getId,key));
	}



   
}
