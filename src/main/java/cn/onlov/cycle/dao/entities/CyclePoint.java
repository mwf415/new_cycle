package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

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
public class CyclePoint implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer activeStatus;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 用户登陆名
     */
         private Integer userId;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 分数
     */
         private Integer score;

        /**
     * 活动ID
     */
         private Integer activeId;


}
