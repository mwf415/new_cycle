package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.ExamUser;
import cn.onlov.cycle.dao.mapper.ExamUserMapper;
import cn.onlov.cycle.dao.interfaces.IExamUserService;
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
public class IExamUserServiceImpl extends ServiceImpl<ExamUserMapper, ExamUser> implements IExamUserService {

}
