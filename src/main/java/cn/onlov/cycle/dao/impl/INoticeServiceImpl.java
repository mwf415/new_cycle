package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.Notice;
import cn.onlov.cycle.dao.mapper.NoticeMapper;
import cn.onlov.cycle.dao.interfaces.INoticeService;
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
public class INoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
