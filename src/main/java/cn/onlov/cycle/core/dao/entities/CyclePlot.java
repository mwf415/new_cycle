package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CyclePlot implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 教学计划，文本格式
     */
         @TableId(value = "plotId", type = IdType.AUTO)
    private Integer plotId;

        /**
     * 基地名称
     */
         @TableField("baseName")
    private String baseName;

        /**
     * 内容
     */
         @TableField("plotTxt")
    private String plotTxt;

        /**
     * 创建时间
     */
         @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;


}
