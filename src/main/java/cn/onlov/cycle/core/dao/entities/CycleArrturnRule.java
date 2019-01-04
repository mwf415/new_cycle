package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CycleArrturnRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("baseName")
    private String baseName;

        /**
     * 学历
     */
         private String education;

        /**
     * 科室
     */
         @TableField("roomName")
    private String roomName;

        /**
     * 周期（单位：月）
     */
         private String period;

        /**
     * 轮转年限类型,存放2  或者3  代表2年或者3年轮转期
     */
         private Integer type;

        /**
     * 排序
     */
         @TableField("roomSort")
    private Integer roomSort;


}
