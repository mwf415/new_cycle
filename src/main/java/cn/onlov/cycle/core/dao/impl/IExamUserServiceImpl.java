package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.ExamUser;
import cn.onlov.cycle.core.dao.mapper.ExamUserMapper;
import cn.onlov.cycle.core.dao.interfaces.IExamUserService;
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
public class IExamUserServiceImpl extends ServiceImpl<ExamUserMapper, ExamUser> implements IExamUserService {

}
