package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.QuestionType;
import cn.onlov.cycle.core.dao.mapper.QuestionTypeMapper;
import cn.onlov.cycle.core.dao.interfaces.IQuestionTypeService;
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
public class IQuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionType> implements IQuestionTypeService {

}
