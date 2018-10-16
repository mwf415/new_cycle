package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.UserType;
import cn.onlov.cycle.dao.mapper.UserTypeMapper;
import cn.onlov.cycle.dao.interfaces.IUserTypeService;
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
public class IUserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements IUserTypeService {

}