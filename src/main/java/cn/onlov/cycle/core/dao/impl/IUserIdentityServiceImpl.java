package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.UserIdentity;
import cn.onlov.cycle.core.dao.mapper.UserIdentityMapper;
import cn.onlov.cycle.core.dao.interfaces.IUserIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaifa
 * @since 2019-01-04
 */
@Service
public class IUserIdentityServiceImpl extends ServiceImpl<UserIdentityMapper, UserIdentity> implements IUserIdentityService {

}
