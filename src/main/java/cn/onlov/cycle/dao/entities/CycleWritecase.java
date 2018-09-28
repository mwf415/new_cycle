package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CycleWritecase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("illName")
    private String illName;

    @TableField("illSex")
    private String illSex;

    @TableField("illNum")
    private String illNum;

    @TableField("illBedNum")
    private String illBedNum;

    @TableField("illRoom")
    private String illRoom;

    @TableField("illAge")
    private String illAge;

    @TableField("baseName")
    private String baseName;

    @TableField("userNum")
    private String userNum;

    @TableField("userName")
    private String userName;

    @TableField("shortAdvice")
    private String shortAdvice;

    @TableField("longAdvice")
    private String longAdvice;

    @TableField("caseText")
    private String caseText;

    @TableField("createTime")
    private String createTime;


}
