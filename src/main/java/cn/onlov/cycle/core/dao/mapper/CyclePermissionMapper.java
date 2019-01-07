package cn.onlov.cycle.core.dao.mapper;

import cn.onlov.cycle.core.dao.entities.CyclePermission;
import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kaifa
 * @since 2019-01-04
 */
public interface CyclePermissionMapper extends BaseMapper<CyclePermission> {

    @Select(    "SELECT distinct(cp.id),cp.name,cp.url,cp.pid, cp.type, cp.sort FROM cycle_permission cp   " +
            "     LEFT JOIN role_permission crp     " +
            "   ON cp.id = crp.pid     " +
            "   LEFT JOIN cycle_user_role cur      " +
            "  ON crp.rid =cur.rid     " +
            "   WHERE system_id = 3        AND cur.uid=#{id}             AND cp.type= #{type}        ORDER BY cp.sort"
            )
    List<CyclePermission> loadUserPermissions(@Param("id") int id,@Param("type") int type);


    @Select("SELECT p.id,p.name,p.pid,p.url,p.type,  (CASE WHEN EXISTS(SELECT 1    FROM role_permission rp WHERE rp.pid=p.id AND rp.rid=#{rid}) " +
            "  THEN 'true' ELSE 'false' END) AS checked     FROM permission p     WHERE system_id = 3  " +
            "   AND p.id!=1     ORDER BY p.sort")
    List<CyclePermission> queryPermissionsListWithSelected (int rid);



}
