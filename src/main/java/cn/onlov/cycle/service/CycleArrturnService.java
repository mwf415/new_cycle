package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import cn.onlov.cycle.pojo.bo.CycleArrturnBo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Date;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface CycleArrturnService {
	
	IPage<CycleArrturn> selectByPage(CycleArrturnBo arrturn);
	
}
