package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.CycleMessage;
import cn.onlov.cycle.core.dao.mapper.CycleMessageMapper;
import cn.onlov.cycle.core.dao.interfaces.ICycleMessageService;
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
public class CycleMessageServiceImpl extends ServiceImpl<CycleMessageMapper, CycleMessage> implements ICycleMessageService {

}
