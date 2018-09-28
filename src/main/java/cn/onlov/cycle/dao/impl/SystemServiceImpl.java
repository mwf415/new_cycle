package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.System;
import cn.onlov.cycle.dao.mapper.SystemMapper;
import cn.onlov.cycle.dao.interfaces.ISystemService;
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
public class SystemServiceImpl extends ServiceImpl<SystemMapper, System> implements ISystemService {

}
