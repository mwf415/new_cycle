package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CycleRoom;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface CycleRoomService {
	
	IPage<CycleRoom> selectByPage(CycleRoomBo base);
	List<CycleRoom> selectAll();
	void deleteByKey(Integer key);
}
