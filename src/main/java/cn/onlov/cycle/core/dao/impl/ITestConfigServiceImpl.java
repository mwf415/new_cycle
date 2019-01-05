package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.TestConfig;
import cn.onlov.cycle.core.dao.mapper.TestConfigMapper;
import cn.onlov.cycle.core.dao.interfaces.ITestConfigService;
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
public class ITestConfigServiceImpl extends ServiceImpl<TestConfigMapper, TestConfig> implements ITestConfigService {

}
