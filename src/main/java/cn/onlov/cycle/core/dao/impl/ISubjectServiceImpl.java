package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.Subject;
import cn.onlov.cycle.core.dao.mapper.SubjectMapper;
import cn.onlov.cycle.core.dao.interfaces.ISubjectService;
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
public class ISubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

}
