package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.QuestionCollection;
import cn.onlov.cycle.dao.mapper.QuestionCollectionMapper;
import cn.onlov.cycle.dao.interfaces.IQuestionCollectionService;
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
public class QuestionCollectionServiceImpl extends ServiceImpl<QuestionCollectionMapper, QuestionCollection> implements IQuestionCollectionService {

}
