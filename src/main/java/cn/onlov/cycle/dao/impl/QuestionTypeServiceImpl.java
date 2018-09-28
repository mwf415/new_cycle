package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.QuestionType;
import cn.onlov.cycle.dao.mapper.QuestionTypeMapper;
import cn.onlov.cycle.dao.interfaces.IQuestionTypeService;
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
public class QuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionType> implements IQuestionTypeService {

}
