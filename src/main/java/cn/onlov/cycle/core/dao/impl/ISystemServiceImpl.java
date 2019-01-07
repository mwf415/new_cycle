package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.System;
import cn.onlov.cycle.core.dao.mapper.SystemMapper;
import cn.onlov.cycle.core.dao.interfaces.ISystemService;
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
public class ISystemServiceImpl extends ServiceImpl<SystemMapper, System> implements ISystemService {

}
