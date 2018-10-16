package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.TestConfig;
import cn.onlov.cycle.dao.mapper.TestConfigMapper;
import cn.onlov.cycle.dao.interfaces.ITestConfigService;
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
public class ITestConfigServiceImpl extends ServiceImpl<TestConfigMapper, TestConfig> implements ITestConfigService {

}