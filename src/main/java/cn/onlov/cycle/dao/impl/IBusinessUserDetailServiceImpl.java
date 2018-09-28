package cn.onlov.cycle.dao.impl;
import cn.onlov.cycle.dao.entities.BusinessUserDetail;
import cn.onlov.cycle.dao.interfaces.IBusinessUserDetailService;
import cn.onlov.cycle.dao.mapper.BusinessUserDetailMapper;
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
public class IBusinessUserDetailServiceImpl extends ServiceImpl<BusinessUserDetailMapper, BusinessUserDetail> implements IBusinessUserDetailService {

}
