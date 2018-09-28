package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.ExamStatus;
import cn.onlov.cycle.dao.mapper.ExamStatusMapper;
import cn.onlov.cycle.dao.interfaces.IExamStatusService;
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
public class ExamStatusServiceImpl extends ServiceImpl<ExamStatusMapper, ExamStatus> implements IExamStatusService {

}
