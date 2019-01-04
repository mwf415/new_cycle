package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pbcatvld")
public class Pbcatvld implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pbvName;

    private String pbvVald;

    private Integer pbvType;

    private Integer pbvCntr;

    private String pbvMsg;


}
