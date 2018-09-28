package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.Subject;
import cn.onlov.cycle.dao.mapper.SubjectMapper;
import cn.onlov.cycle.dao.interfaces.ISubjectService;
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
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

}
