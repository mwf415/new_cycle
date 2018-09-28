package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class CyleNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("arrTurnId")
    private Integer arrTurnId;

    @TableField("sickNum")
    private String sickNum;

    @TableField("inDate")
    private Date inDate;

    @TableField("sickDes")
    private String sickDes;

    @TableField("skillName")
    private String skillName;

    @TableField("startTime")
    private Date startTime;

    @TableField("sickDetail")
    private String sickDetail;

    @TableField("actRole")
    private String actRole;

    private Integer status;


}
