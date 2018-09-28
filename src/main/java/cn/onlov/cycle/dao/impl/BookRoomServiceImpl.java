package cn.onlov.cycle.dao.impl;

import cn.onlov.cycle.dao.entities.BookRoom;
import cn.onlov.cycle.dao.mapper.BookRoomMapper;
import cn.onlov.cycle.dao.interfaces.IBookRoomService;
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
public class BookRoomServiceImpl extends ServiceImpl<BookRoomMapper, BookRoom> implements IBookRoomService {

}
