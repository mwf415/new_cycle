package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.UserEducation;
import cn.onlov.cycle.dao.mapper.UserEducationMapper;
import cn.onlov.cycle.dao.interfaces.IUserEducationService;
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
public class IUserEducationServiceImpl extends ServiceImpl<UserEducationMapper, UserEducation> implements IUserEducationService {

}
