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
public class CycleActivesUser implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 用户和活动关联表ID
     */
         @TableId(value = "actives_user_id", type = IdType.AUTO)
    private Long activesUserId;

        /**
     * 用户名称
     */
         private String realName;

        /**
     * 用户ID
     */
         private Long userId;

        /**
     * 活动ID
     */
         private Long activesId;

        /**
     * 这个只针对入科教育的，是否参加
     */
         private Integer isIn;

        /**
     * 身份，1老师和2学生
     */
         private Integer identityId;

        /**
     * 状态，是否完成 
     */
         private Integer status;


}
