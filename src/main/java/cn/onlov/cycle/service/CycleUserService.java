package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CycleRole;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.pojo.bo.UserBo;
import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;

public interface CycleUserService {

	IPage<User> getBusinessPageUser(UserBo bo) ;
	
	User selectByLoginName(String loginName);
	
	void delUser(Integer userid);
	
	List<User> selectByLoginNames(String[] loginNames);

}
