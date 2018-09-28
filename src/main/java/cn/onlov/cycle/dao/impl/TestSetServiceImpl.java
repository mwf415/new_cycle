package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.TestSet;
import cn.onlov.cycle.dao.mapper.TestSetMapper;
import cn.onlov.cycle.dao.interfaces.ITestSetService;
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
public class TestSetServiceImpl extends ServiceImpl<TestSetMapper, TestSet> implements ITestSetService {

}
