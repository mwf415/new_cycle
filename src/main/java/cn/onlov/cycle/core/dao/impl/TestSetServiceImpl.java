package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.TestSet;
import cn.onlov.cycle.core.dao.mapper.TestSetMapper;
import cn.onlov.cycle.core.dao.interfaces.ITestSetService;
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
public class TestSetServiceImpl extends ServiceImpl<TestSetMapper, TestSet> implements ITestSetService {

}
