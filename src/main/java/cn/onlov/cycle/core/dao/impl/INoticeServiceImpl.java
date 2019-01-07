package cn.onlov.cycle.core.dao.impl;

import cn.onlov.cycle.core.dao.entities.Notice;
import cn.onlov.cycle.core.dao.mapper.NoticeMapper;
import cn.onlov.cycle.core.dao.interfaces.INoticeService;
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
public class INoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
