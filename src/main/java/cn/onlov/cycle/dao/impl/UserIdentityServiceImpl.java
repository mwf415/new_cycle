package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.UserIdentity;
import cn.onlov.cycle.dao.mapper.UserIdentityMapper;
import cn.onlov.cycle.dao.interfaces.IUserIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaifa
 * @since 2018-09-28
 */
@Service
public class UserIdentityServiceImpl extends ServiceImpl<UserIdentityMapper, UserIdentity> implements IUserIdentityService {

}
