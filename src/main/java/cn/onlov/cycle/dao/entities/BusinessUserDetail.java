package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

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
@TableName("business_user_detail")
public class BusinessUserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "busiess_user_detail_id", type = IdType.ID_WORKER)
    private Long busiessUserDetailId;


}
