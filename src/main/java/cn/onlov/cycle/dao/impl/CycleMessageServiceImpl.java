package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.CycleMessage;
import cn.onlov.cycle.dao.mapper.CycleMessageMapper;
import cn.onlov.cycle.dao.interfaces.ICycleMessageService;
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
public class CycleMessageServiceImpl extends ServiceImpl<CycleMessageMapper, CycleMessage> implements ICycleMessageService {

}
