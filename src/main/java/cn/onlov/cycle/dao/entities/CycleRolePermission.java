package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kaifa
 * @since 2018-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CycleRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 角色id
     */
         private Long roleId;

        /**
     * 权限id
     */
         private Long pid;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
