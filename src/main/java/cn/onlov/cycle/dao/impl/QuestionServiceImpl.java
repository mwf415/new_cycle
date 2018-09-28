package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.Question;
import cn.onlov.cycle.dao.mapper.QuestionMapper;
import cn.onlov.cycle.dao.interfaces.IQuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
