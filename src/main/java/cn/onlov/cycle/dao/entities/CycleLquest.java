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
public class CycleLquest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "questId", type = IdType.AUTO)
    private Integer questId;

    @TableField("questTxt")
    private String questTxt;

    @TableField("lectureNum")
    private String lectureNum;


}
