package cn.onlov.cycle.core.dao.interfaces;

import cn.onlov.cycle.core.dao.entities.CycleRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaifa
 * @since 2019-01-04
 */
public interface ICycleRoleService extends IService<CycleRole> {

    List<CycleRole> queryRoleListByUserId (Integer roleId);

}
