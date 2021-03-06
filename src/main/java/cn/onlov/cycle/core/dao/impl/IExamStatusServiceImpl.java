package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.ExamStatus;
import cn.onlov.cycle.core.dao.mapper.ExamStatusMapper;
import cn.onlov.cycle.core.dao.interfaces.IExamStatusService;
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
public class IExamStatusServiceImpl extends ServiceImpl<ExamStatusMapper, ExamStatus> implements IExamStatusService {

}
