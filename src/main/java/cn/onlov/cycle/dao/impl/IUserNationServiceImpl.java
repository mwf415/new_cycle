package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.UserNation;
import cn.onlov.cycle.dao.mapper.UserNationMapper;
import cn.onlov.cycle.dao.interfaces.IUserNationService;
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
public class IUserNationServiceImpl extends ServiceImpl<UserNationMapper, UserNation> implements IUserNationService {

}
