package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.CyclePoint;
import cn.onlov.cycle.dao.mapper.CyclePointMapper;
import cn.onlov.cycle.dao.interfaces.ICyclePointService;
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
public class CyclePointServiceImpl extends ServiceImpl<CyclePointMapper, CyclePoint> implements ICyclePointService {

}
